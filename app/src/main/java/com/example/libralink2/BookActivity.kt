package com.example.libralink2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.libralink2.databinding.ActivityBookBinding
import com.example.libralink2.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpClient.log
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class BookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //var viewModel = ViewModelProvider(this).get(BookActivityViewModel::class.java)


        binding.btnSearch.setOnClickListener {
            searchBook()
        }


    }

    private fun searchBook() {
        val query = binding.etSearch.text.toString()
        val client = AsyncHttpClient()
        val url = "https://www.googleapis.com/books/v1/volumes?q=${query}"
        client.get(url,object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                log.d(TAG , result)

                try {
                    val jsonObject = JSONObject(result)
                    val itemsArray = jsonObject.getJSONArray("items")

                    var i = 0
                    var bookTitle = ""
                    var bookAuthor = ""


                    while (i < itemsArray.length()) {
                        val book = itemsArray.getJSONObject(i)
                        val volumeInfo = book.getJSONObject("volumeInfo")
                        try {
                            bookTitle = volumeInfo.getString("title")
                            bookAuthor = volumeInfo.getString("authors")
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                        i++
                    }
                    binding.apply {
                        tvBookName.text = bookTitle
                        tvAuthorName.text = bookAuthor
                    }
                }catch (e: Exception) {
                    Toast.makeText(this@BookActivity, e.message, Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "StatusCode: Bad Request"
                    403 -> "StatusCode: Forbidden"
                    404 -> "StatusCode: Not Found"
                    else -> " StatusCode: ${error?.message}"
                }
                Toast.makeText(this@BookActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })

    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
package com.example.libralink2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.libralink2.databinding.FragmentBookDetailsBinding
import com.example.libralink2.databinding.FragmentLoginBinding
import com.example.libralink2.viewmodels.BookViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import org.json.JSONObject
import java.lang.Exception

class BookDetailsFragment : Fragment() {
    private var _binding: FragmentBookDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
//
//    private fun searchBook() {
//        val query = binding..text.toString()
//        val client = AsyncHttpClient()
//        val url = "https://www.googleapis.com/books/v1/volumes?q=${query}"
//        client.get(url, object : AsyncHttpResponseHandler() {
//            override fun onSuccess(
//                statusCode: Int,
//                headers: Array<out cz.msebera.android.httpclient.Header>,
//                responseBody: ByteArray
//            ) {
//                val result = String(responseBody)
//                Log.d(TAG, result)
//
//                try {
//                    val jsonObject = JSONObject(result)
//                    val itemsArray = jsonObject.getJSONArray("items")
//
//                    var i = 0
//                    var bookTitle = ""
//                    var bookAuthor = ""
//                    var pages = ""
//                    var coverImageUrl = ""
//
//                    while (i < itemsArray.length()) {
//                        val book = itemsArray.getJSONObject(i)
//                        val volumeInfo = book.getJSONObject("volumeInfo")
//                        try {
//                            bookTitle = volumeInfo.getString("title")
//                            bookAuthor = volumeInfo.getString("authors")
//                            pages = volumeInfo.optString("pageCount", "")
//                            val imageLinks = volumeInfo.getJSONObject("imageLinks")
//                            coverImageUrl = imageLinks.getString("thumbnail")
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//                        i++
//                    }
//
//                    bookViewModel.apply {
//                        this.bookTitle = bookTitle
//                        this.bookAuthor = bookAuthor
//                        this.pages = pages
//                        this.coverImageUrl = coverImageUrl
//                    }
//
//                    updateUI()
//                } catch (e: Exception) {
//                    Toast.makeText(this@BookDetailsFragment, e.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(
//                statusCode: Int,
//                headers: Array<out cz.msebera.android.httpclient.Header>?,
//                responseBody: ByteArray?,
//                error: Throwable?
//            ) {
//                val errorMessage = when (statusCode) {
//                    401 -> "StatusCode: Bad Request"
//                    403 -> "StatusCode: Forbidden"
//                    404 -> "StatusCode: Not Found"
//                    else -> " StatusCode: ${error?.message}"
//                }
//                Toast.makeText(this@BookDetailsFragment, errorMessage, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//
//    private fun updateUI() {
//        binding.apply {
//            tvTitleResult.text = bookViewModel.bookTitle
//            tvAuthorResult.text = bookViewModel.bookAuthor
//            tvPages.text = bookViewModel.pages
//
//            // Laden und Anzeigen des Buchcover-Fotos
//            Glide.with(this@BookDetailsFragment)
//                .load(bookViewModel.coverImageUrl)
//                .into(tvBookImg)
//        }
//    }
//
//    companion object {
//        private val TAG = BookDetailsFragment::class.java.simpleName
//    }
}
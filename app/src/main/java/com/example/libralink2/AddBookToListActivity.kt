package com.example.libralink2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.libralink2.databinding.ActivityAddBookToListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddBookToListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBookToListBinding
  // private lateinit var bookDb : BookDataBase
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       binding= ActivityAddBookToListBinding.inflate(layoutInflater)
       setContentView(binding.root)

    //   bookDb= BookDataBase.getDatabase(this)

      binding.btAddBook.setOnClickListener {
           writeData()
      }
        binding.btDeleteAll.setOnClickListener {
           /* GlobalScope.launch {
                bookDb
            }

            */
        }
       binding.btnShow.setOnClickListener {
           readData()
        }
    }
//
    private fun readData() {
//       lateinit var books :Book
//       GlobalScope.launch {
//          /// books = bookDb.booksDao().readAll()  Frage
//           displayData(books)
//       }
//    }
//
//    private suspend fun displayData(book:Book){
//        withContext(Dispatchers.Main){
//        }
   }
//
   private fun writeData() {
//        val nameofbook = binding.etNameOfBook.text.toString()
//        val nameofauthor = binding.etNameOfAuthor.text.toString()
//        val category = binding.spCategory.toString()
//        val page = binding.etPages.text.toString()
//        if (nameofauthor.isNotEmpty() && nameofbook.isNotEmpty()){
//            val book = Book(
//                null, nameofbook,nameofauthor,null,null,category , page
//            )
//            GlobalScope.launch(Dispatchers.IO){
//                bookDb.booksDao().insert(book)
//            }
//            binding.etNameOfBook.text.clear()
//            binding.etNameOfAuthor.text.clear()
//            binding.etPages.text.clear()
//            Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show()
//        }else{
//            Toast.makeText(this, "Not Successfully", Toast.LENGTH_SHORT).show()
//        }
    }
}
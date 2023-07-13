package com.example.libralink2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.database.ListDataBase
import com.example.libralink2.database.Listen
import com.example.libralink2.databinding.ActivityAddListBinding
import com.example.libralink2.databinding.ActivityMyBookBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMyBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameoflist = "my_book"

        val my_book = Listen(
            null, nameoflist,
        )

        GlobalScope.launch(Dispatchers.IO) {
            ListDataBase.getDatabase(applicationContext).ListenDao().insertListen(my_book)
        }

        binding.btnAddTodo.setOnClickListener {
        //    val nameofbook = binding.etTodo.text.toString()

        }
    }
}



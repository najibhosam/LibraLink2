package com.example.libralink2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libralink2.databinding.ActivityAddListBinding

class AddListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAddListBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAddList.setOnClickListener {
            val intent = Intent(this,AddBookToListActivity::class.java)
            startActivity(Intent(intent))
        }
    }

}
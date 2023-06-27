package com.example.libralink2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.libralink2.databinding.ActivityBookBinding
import com.example.libralink2.databinding.ActivityMainBinding

class BookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewModel = ViewModelProvider(this).get(BookActivityViewModel::class.java)

        viewModel.getInfo()

    }
}
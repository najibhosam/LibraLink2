package com.example.libralink2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)

        val btnGetStart : Button = findViewById(R.id.btnGetStart)

        btnGetStart.setOnClickListener {
            Intent(this ,MainActivity::class.java ).also {
                startActivity(it)
            }
        }
    }
}
package com.example.libralink2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        val btnLogin :Button = findViewById(R.id.btnLogin)
        val btnSkip : Button = findViewById(R.id.btnSkip)
        btnLogin.setOnClickListener {
            Intent(this ,LoginActivity::class.java ).also {
                startActivity(it)
            }
        }
        btnSkip.setOnClickListener {
            Intent(this ,MainActivity::class.java ).also {
                startActivity(it)
            }
        }
    }
}
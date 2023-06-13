package com.example.libralink2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libralink2.recyclerview.FriendsRVAdapter
import com.example.libralink2.recyclerview.FriendsRvClass

class FriendsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
        var todoList = mutableListOf(
            FriendsRvClass("john",findViewById(R.drawable.ic_profile)),
            FriendsRvClass("Sahra",null),
            FriendsRvClass("Moh",null)
        )

        val adapter= FriendsRVAdapter(todoList)
        val rvFriend: RecyclerView = findViewById(R.id.rvFriend)
        rvFriend.layoutManager = LinearLayoutManager(this)
        rvFriend.adapter = adapter
    }
}
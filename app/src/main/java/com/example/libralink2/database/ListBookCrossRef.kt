package com.example.libralink2.database

import androidx.room.Entity

@Entity(primaryKeys = ["listId", "bookId"])
data class ListBookCrossRef(
    val listId: Int,
    val bookId: Int
)
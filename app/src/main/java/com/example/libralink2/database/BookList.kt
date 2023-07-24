package com.example.libralink2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_list")
data class BookList(
    @PrimaryKey(autoGenerate = true)
    val listId: Int = 0,
    @ColumnInfo(name = "user_creator_id")
    val userCreatorId: Int = 0,
    @ColumnInfo(name = "list_name")
    val listName: String
)
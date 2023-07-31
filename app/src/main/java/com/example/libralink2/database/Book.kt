package com.example.libralink2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val bookId: Int = 0,
    @ColumnInfo(name = "book_name")
    val bookName: String = "",
    @ColumnInfo(name = "bookAuthor")
    val bookAuthor: String = "",
    @ColumnInfo(name = "pages")
    val pages: String = "",
    @ColumnInfo(name = "imageSrc")
    val imageSrc: String = "",
    @ColumnInfo(name = "year")
    val year: String = ""
)
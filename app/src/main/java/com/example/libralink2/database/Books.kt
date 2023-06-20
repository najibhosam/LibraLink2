package com.example.libralink2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Books_table")
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "book_name") val BookName: String?,
    @ColumnInfo(name = "author_name") val AuthorName: String?,
    @ColumnInfo(name = "price") val Price: Int?,
    @ColumnInfo(name = "Photo") val Photo: Int?,
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "Pages") val pages: String?
)

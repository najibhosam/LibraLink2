package com.example.libralink2.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ListWithBooks(
    @Embedded val bookList: BookList,
    @Relation(
        parentColumn = "listId",
        entityColumn = "bookId",
        associateBy = Junction(ListBookCrossRef::class)
    )
    val books: List<Book>
)
package com.example.libralink2.database

import androidx.room.*
import kotlin.collections.List

@Dao
interface BooksDao {
    @Query( "SELECT * FROM Books_table")
    fun readAll(): List<Book>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(Book: Book)
    @Query("SELECT * FROM Books_table WHERE book_name LIKE :book_name")
    suspend fun findBook (book_name : String):Book
    @Delete
    suspend fun delete (Book: Book)
    @Query("DELETE FROM Books_table")
    suspend fun deleteAll()

}
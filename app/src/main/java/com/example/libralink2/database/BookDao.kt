package com.example.libralink2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BooksDao {
    @Query( "SELECT * FROM Books_table")
    fun readAll(): List<Books>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Books)

}
package com.example.libralink2.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(list: BookList)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBook(book: Book)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListBookCrossRef(crossRef: ListBookCrossRef)
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Query("SELECT * from user WHERE userId = :userId")
    fun getUser(userId: Int): Flow<User>
    @Query("SELECT userId from user WHERE username = :userName")
    fun getUserId(userName: String): Int
    @Transaction
    @Query("SELECT * from user WHERE userId = :userId")
    suspend fun getUserWithBookLists(userId: Int): List<UserWithBookLists>
    @Transaction
    @Query("SELECT * from book_list WHERE listId = :listId")
    suspend fun getListWithBooks(listId: Int): List<ListWithBooks>
}
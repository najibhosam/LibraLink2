package com.example.libralink2.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface UserDao {

    @Query("SELECT * FROM User_table")
    fun readAllUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(User: User)

    @Query("SELECT * FROM User_table WHERE list_name LIKE :list_name")
    suspend fun findUser (list_name : String):User

    @Transaction
    @Query("SELECT * FROM User_table")
    fun getUserWithLists() : List<UserWithBookLists>

    @Delete
    suspend fun deleteUser (user: User)
    @Query("DELETE FROM User_table")
    suspend fun deleteAllUser()

}
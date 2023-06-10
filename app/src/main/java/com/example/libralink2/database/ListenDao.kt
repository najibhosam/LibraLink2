package com.example.libralink2.database

import androidx.room.*

@Dao
interface ListenDao {

    @Query("SELECT * FROM listen_table")
    fun readAllListen(): List<Listen>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListen(Listen: Listen)

    @Query("SELECT * FROM listen_table WHERE list_name LIKE :list_name")
    suspend fun findListen (list_name : String):Listen

    @Delete
    suspend fun deleteListen (List: Listen)
    @Query("DELETE FROM listen_table")
    suspend fun deleteAllListen()

}
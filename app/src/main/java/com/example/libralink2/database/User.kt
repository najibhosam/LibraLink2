package com.example.libralink2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_table")
data class User (
    @PrimaryKey(autoGenerate = true)val userId:Int?,
    @ColumnInfo(name = "first_name") val firstName :String?,
    @ColumnInfo(name = "list_name") val listName :String?,
    @ColumnInfo(name = "email") val email :String?,
    @ColumnInfo(name = "password") val password :String?,
//    @ColumnInfo(name = "Listen") val lists :List<Listen> = listOf<Listen>()


    //  @ColumnInfo(name = "Book") val book: Int?
)


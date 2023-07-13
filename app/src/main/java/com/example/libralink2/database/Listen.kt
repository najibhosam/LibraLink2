package com.example.libralink2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listen_table")
data class Listen (
    @PrimaryKey(autoGenerate = true)val listId:Int?,
    @ColumnInfo(name = "list_name") val listName :String?,
    val userCreatorId: Long
    //@ColumnInfo(name = "Book") val book: Int?
)

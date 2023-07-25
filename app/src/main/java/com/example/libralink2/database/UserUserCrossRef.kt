package com.example.libralink2.database

import androidx.room.Entity

@Entity(primaryKeys = ["userId", "userId"])
data class UserUserCrossRef(
    val userId: Int,
    val friendId: Int
)
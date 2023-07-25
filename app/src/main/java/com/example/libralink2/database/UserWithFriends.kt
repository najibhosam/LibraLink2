package com.example.libralink2.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithFriends(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "friendId",
        associateBy = Junction(UserUserCrossRef::class)
    )
    val friends: List<User>
)
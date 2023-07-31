package com.example.libralink2.database

import androidx.room.*

//room@Entity(tableName = "user_with_friends)
//data class UserWithFriends(
//    @Embedded val user: User,
//    @Relation(
//        parentColumn = "userId",
//        entityColumn = "friendId",
//        associateBy = Junction(UserUserCrossRef::class)
//    )
//    val friends: List<User>
//)
package com.example.libralink2.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
data class UserWithBookListsAndBooks(
    @Embedded val user: User,
    @Relation(
        entity = BookList::class,
        parentColumn = "userId",
        entityColumn = "user_creator_id"
    )
    val bookLists: List<ListWithBooks>
)
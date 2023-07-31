package com.example.libralink2.database

import androidx.room.*
import com.example.libralink2.ui.fragments.BookListFragmentDirections
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertList(list: BookList)
////    @Insert(onConflict = OnConflictStrategy.IGNORE)
////    suspend fun insertBook(book: Book)
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertListBookCrossRef(crossRef: ListBookCrossRef)
////    @Insert(onConflict = OnConflictStrategy.IGNORE)
////    suspend fun insertUserUserCrossRef(crossRef: UserUserCrossRef)
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Query("SELECT * from user WHERE userId = :userId")
    fun getUser(userId: Int): Flow<User>
////    @Query("SELECT * from book_list WHERE user_creator_id = :userId")
////    fun getBookLists(userId: Int): Flow<List<BookList>>
    @Query("SELECT userId from user WHERE username = :userName")
    fun getUserId(userName: String): Int
//    @Query("SELECT EXISTS (SELECT * FROM user WHERE username = :userName"))
//    fun userExists(userName: String) : Boolean
//    @Transaction
//    @Query("SELECT * from user WHERE userId = :userId")
//    fun getUsersWithBookLists(userId: Int): Flow<List<UserWithBookListsAndBooks>>
//    @Transaction
//    @Query("SELECT * from book_list WHERE listId = :listId")
//    suspend fun getListWithBooks(listId: Int): List<ListWithBooks>
//    @Transaction
//    @Query("SELECT * FROM user WHERE userId = :userId")
//    suspend fun getFriendsOfUser(userId: Int): List<UserWithFriends>
}
package com.example.libralink2.viewmodels

import android.content.ClipData
import android.util.Patterns
import androidx.lifecycle.*
import com.example.libralink2.database.BookList
import com.example.libralink2.database.User
import com.example.libralink2.database.UserDao
//import com.example.libralink2.database.UserWithFriends
import kotlinx.coroutines.launch

class ProfileViewModel(private val userDao: UserDao) : ViewModel() {

    lateinit var currentUser: LiveData<User>
    lateinit var list: BookList
    private var userId: Int = 0

//    val allLists: LiveData<List<BookList>> = userDao.getBookLists(userId).asLiveData()

    private fun insertUserIntoDatabase(user: User) {
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }

    private fun insertListIntoDatabase(bookList: BookList) {
        viewModelScope.launch {
//            userDao.insertList(bookList)
        }
    }

    fun createDefaultUser() {
        addNewUser("name", "lname", "uname", "email", "p")
//        createDefaultLists(user.userId)
    }
//    fun createDefaultLists(userId: Int) {
//        var defaultBookList = listOf<BookList>(
//            getNewListEntry(userId, "My books"),
//            getNewListEntry(userId, "Wish list"),
//            getNewListEntry(userId, "Borrowed books"),
//            getNewListEntry(userId, "Favorite books")
//        )
//        defaultBookList.forEach { insertListIntoDatabase(it) }
//    }

    private fun getNewUserEntry(firstName: String, lastName: String, userName: String, email: String, password: String): User {
        return User(
            firstName = firstName,
            lastName = lastName,
            userName = userName,
            email = email,
            password = password
        )
    }

//    private fun getFriends(userName: String) : LiveData<List<UserWithFriends>> {
//        var id = userDao.getUserId(userName)
//        var friends = userDao.getFriendsOfUser(id)
//    }

//    private fun getNewListEntry(creatorId: Int, listName: String): BookList {
//        return BookList(
//            userCreatorId = creatorId,
//            listName = listName
//        )
//    }

    fun addNewUser(firstName: String, lastName: String, userName: String, email: String, password: String) {
        val newUser = getNewUserEntry(firstName, lastName, userName, email, password)
        insertUserIntoDatabase(newUser)
    }

    fun retrieveUser(id: Int): LiveData<User> {
        return userDao.getUser(id).asLiveData()
    }

//    fun checkIfUserExists(userName: String) : Boolean {
////        var userExists = userDao.userExists(userName)
////        return userExists
//    }

    fun checkPassword(userName: String, passwordInput: String) : Boolean {
        var userId = userDao.getUserId(userName)
        var user = retrieveUser(userId)
        if(user.value!!.password == passwordInput) {
            currentUser = user
            this.userId = userId
            return true
        }
        return false
    }

//    fun addNewList(creatorId: Int, listName: String) {
//        val newList = getNewListEntry(creatorId, listName)
//        insertListIntoDatabase(newList)
//    }

//    fun generateDefaultLists() {
//
//    }

    fun isUserEntryValid(firstName: String, lastName: String, userName: String, email: String, password: String): Boolean {
        if (firstName.isBlank() || lastName.isBlank() || userName.isBlank() || email.isBlank() || password.isBlank()) {
            return false
        }
        return true
    }

}

class ProfileViewModelFactory(
    private val userDao: UserDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
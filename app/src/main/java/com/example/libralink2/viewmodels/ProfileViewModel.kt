package com.example.libralink2.viewmodels

import androidx.lifecycle.*
import com.example.libralink2.database.BookList
import com.example.libralink2.database.User
import com.example.libralink2.database.UserDao
import kotlinx.coroutines.launch

class ProfileViewModel(private val userDao: UserDao) : ViewModel() {

    lateinit var user: User
    lateinit var list: BookList

    private fun insertUserIntoDatabase(user: User) {
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }

    private fun insertListIntoDatabase(bookList: BookList) {
        viewModelScope.launch {
            userDao.insertList(bookList)
        }
    }

    private fun getNewUserEntry(firstName: String, lastName: String, userName: String, email: String, password: String): User {
        return User(
            firstName = firstName,
            lastName = lastName,
            userName = userName,
            email = email,
            password = password
        )
    }

    private fun getNewListEntry(creatorId: Int, listName: String): BookList {
        return BookList(
            userCreatorId = creatorId,
            listName = listName
        )
    }

    fun addNewUser(firstName: String, lastName: String, userName: String, email: String, password: String) {
        val newUser = getNewUserEntry(firstName, lastName, userName, email, password)
        insertUserIntoDatabase(newUser)
    }

    fun addNewList(creatorId: Int, listName: String) {
        val newList = getNewListEntry(creatorId, listName)
        insertListIntoDatabase(newList)
    }

    fun generateDefaultLists() {

    }

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
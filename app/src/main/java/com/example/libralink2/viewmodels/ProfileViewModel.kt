package com.example.libralink2.viewmodels

import android.content.ClipData
import androidx.lifecycle.*
import com.example.libralink2.database.User
import com.example.libralink2.database.UserDao
import kotlinx.coroutines.launch

class ProfileViewModel(private val userDao: UserDao) : ViewModel() {

    private fun insertUserIntoDatabase(user: User) {
        viewModelScope.launch {
            userDao.insertUser(user)
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

    fun addNewUser(firstName: String, lastName: String, userName: String, email: String, password: String) {
        val newUser = getNewUserEntry(firstName, lastName, userName, email, password)
        insertUserIntoDatabase(newUser)
    }


    fun isEntryValid(firstName: String, lastName: String, userName: String, email: String, password: String): Boolean {
        if (firstName.isBlank() || lastName.isBlank() || userName.isBlank() || email.isBlank() || password.isBlank()) {
            return false
        }
        return true
    }

//    private val _name = MutableLiveData<String>("")
//    var name: LiveData<String> = _name
//
//    private val _lastName = MutableLiveData<String>("")
//    var lastName: LiveData<String> = _lastName
//
//    private val _email = MutableLiveData<String>("")
//    var email: LiveData<String> = _email
//
//    private val _password = MutableLiveData<String>("")
//    var password: LiveData<String> = _password
//
//    fun setName(inputName: String) {
//        _name.value = inputName
//    }
//
//    fun setLastName(inputLastName: String) {
//        _lastName.value = inputLastName
//    }
//
//    fun setEmail(inputEmail: String) {
//        _name.value = inputEmail
//    }
//
//    fun setPassword(inputPassword: String) {
//        _name.value = inputPassword
//    }

//    private fun validateData() {
//        name = binding.etName.text.toString().trim()
//        email = binding.etEmail.text.toString().trim()
//        val cPassword = binding.etCpassword.toString().trim()
//
//        if (name.isEmpty()){
//
//            Toast.makeText(this, "Enter your name ...", Toast.LENGTH_SHORT).show()
//        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            Toast.makeText(this, "Invalid Pattern", Toast.LENGTH_SHORT).show()
//        }else if (password.isEmpty()){
//            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
//        }else if (cPassword.isEmpty()){
//            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
//        }else if (password !=cPassword){
//            Toast.makeText(this, "Password doesn't match...", Toast.LENGTH_SHORT).show()
//        }
//        else createUserAccount()
//
//    }
//
//    private fun createUserAccount() {
//        progressDialog.setMessage("Creating Account...")
//        progressDialog.show()
//
//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//            .addOnSuccessListener {
//                updateUserInfo()
//
//            }
//            .addOnFailureListener{e->
//                progressDialog.dismiss()
//                Toast.makeText(this, "Failed creating account due to ${e.message}", Toast.LENGTH_SHORT).show()
//            }
//    }
//
//    private fun updateUserInfo() {
//        progressDialog.setMessage("Saving user Info...")
//
//        val timestamp = System.currentTimeMillis()
//
//        val uid = firebaseAuth.uid.toString()
//
//        val hashMap : HashMap<String , Any> = HashMap()
//        hashMap["uid"] = uid
//        hashMap["email"] = email
//        hashMap["name"] = name
//        hashMap["userType"] = "user"
//        hashMap["timestamp"] = timestamp
//
//
//        val ref = FirebaseDatabase.getInstance().getReference("User")
//        ref.child(uid!!)
//            .setValue(hashMap)
//            .addOnSuccessListener {
//
//                progressDialog.dismiss()
//                Toast.makeText(this, "Account created...", Toast.LENGTH_SHORT).show()
//                startActivity(Intent(this@RegisterFragment, MainActivity::class.java))
//                finish()
//
//            }
//            .addOnFailureListener {e->
//                progressDialog.dismiss()
//                Toast.makeText(this, "Failed saving user due to ${e.message}", Toast.LENGTH_SHORT).show()
//
//            }
//    }
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
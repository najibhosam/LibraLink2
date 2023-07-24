package com.example.libralink2

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.libralink2.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var firebaseAuth : FirebaseAuth

    private lateinit var progressDialog :ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)


        binding.BackBtn.setOnClickListener{
            onBackPressed()
        }

        binding.btnSignUp.setOnClickListener {


            validatreData()
        }
    }

    private var name = ""
    private var email = ""
    private var password = ""

    private fun validatreData() {
        name = binding.etName.text.toString().trim()
        email = binding.etEmail.text.toString().trim()
        val cPassword = binding.etCpassword.toString().trim()

        if (name.isEmpty()){

            Toast.makeText(this, "Enter your name ...", Toast.LENGTH_SHORT).show()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Invalid Pattern", Toast.LENGTH_SHORT).show()
        }else if (password.isEmpty()){
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
        }else if (cPassword.isEmpty()){
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
        }else if (password !=cPassword){
            Toast.makeText(this, "Password doesn't match...", Toast.LENGTH_SHORT).show()
        }
        else createUserAccount()

    }

    private fun createUserAccount() {
       /* progressDialog.setMessage("Creating Account...")
        progressDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                updateUserInfo()

            }
            .addOnFailureListener{e->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed creating account due to ${e.message}", Toast.LENGTH_SHORT).show()
            }

        */
    }

    private fun updateUserInfo() {
        /*
        progressDialog.setMessage("Saving user Info...")

        val timestamp = System.currentTimeMillis()

        val uid = firebaseAuth.uid.toString()

        val hashMap : HashMap<String , Any> = HashMap()
        hashMap["uid"] = uid
        hashMap["email"] = email
        hashMap["name"] = name
        hashMap["userType"] = "user"
        hashMap["timestamp"] = timestamp


        val ref = FirebaseDatabase.getInstance().getReference("User")
        ref.child(uid!!)
           .setValue(hashMap)
            .addOnSuccessListener {

                progressDialog.dismiss()
                Toast.makeText(this, "Account created...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                finish()

            }
            .addOnFailureListener {e->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed saving user due to ${e.message}", Toast.LENGTH_SHORT).show()

            }

*/
    }
}


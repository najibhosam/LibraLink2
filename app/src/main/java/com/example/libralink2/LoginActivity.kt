package com.example.libralink2

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.libralink2.databinding.ActivityLoginBinding
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ValueEventListener

class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding

    //private lateinit var firebaseAuth : FirebaseAuth

    private lateinit var progressDialog :ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

     /*   firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.tvNoAccount.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            validateData()
        }
        */

    }
    private var password= ""
    private var email = ""

    private fun validateData() {
        email= binding.emailEt.text.toString()
        password = binding.passwordEt.text.toString()
        
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
        }
        else if (password.isEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show()
        }
        else
            loginUser()
    }

    private fun loginUser() {
      /*  progressDialog.setMessage("Logging In...")
        progressDialog.show()
        
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener { 
                checkUser()
            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(this, "Kogin failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
            */

    }

    private fun checkUser() {
     /*   progressDialog.setMessage("CheckingUser...")
        val firebaseUser = firebaseAuth.currentUser!!

        val ref = FirebaseDatabase.getInstance().getReference("User")
        val uid = firebaseAuth.uid
        ref.child(firebaseUser.toString())
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onCancelled(error: DatabaseError) {
                    progressDialog.dismiss()
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                }

                override fun onDataChange(snapshot: DataSnapshot) {


                }
            })

      */
    }

}
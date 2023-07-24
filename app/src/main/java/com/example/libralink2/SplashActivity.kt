package com.example.libralink2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.libralink2.ui.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)

        Handler().postDelayed({
          //  checkUser()
            startActivity(Intent(this, MainActivity::class.java))
        },3000)
    }

   /* private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser==null){
            startActivity(Intent(this , MainActivity::class.java))
        }
        else{
            val ref = FirebaseDatabase.getInstance().getReference("User")
                //ref.child(firebaseUser,uid) Frageeeeee
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(error: DatabaseError) {
                        startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                    }

                    override fun onDataChange(snapshot: DataSnapshot) {


                    }
                })
        }
    }*/
}
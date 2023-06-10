package com.example.libralink2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.libralink2.database.ListDataBase
import com.example.libralink2.database.Listen
import com.example.libralink2.databinding.ActivityAddListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddListBinding
    private lateinit var listDb : ListDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAddListBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAddList.setOnClickListener {
            val intent = Intent(this,AddBookToListActivity::class.java)
                intList()
            startActivity(Intent(intent))
            }
        }

    private fun intList() {

        val nameoflist = binding.etNameOfList.text.toString()
        if (nameoflist.isNotEmpty()){
            val list = Listen(
                null, nameoflist,
            )
            GlobalScope.launch(Dispatchers.IO){
                listDb.ListenDao().insertListen(list)
            }
            binding.etNameOfList.text.clear()
            Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Not Successfully", Toast.LENGTH_SHORT).show()
        }
    }
}

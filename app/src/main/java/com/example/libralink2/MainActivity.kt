package com.example.libralink2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.libralink2.databinding.ActivityMainBinding
import com.example.libralink2.fragment.AddBookFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView :BottomNavigationView = binding.bottomNavigationView// to detect the icon id
        val navController = findNavController(R.id.nav_host_fragment)// to detect the Fragment id

        val appBarConfiguration = AppBarConfiguration(
            setOf
                (R.id.homeFragment,R.id.messagesFragment,R.id.listsFragment,R.id.profileFragment)
        )
        setupActionBarWithNavController(navController,appBarConfiguration) // um die titel oben zu stellen

        bottomNavigationView.setupWithNavController(navController)// to marge the bottomNavigationView with fragment
        

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val addBooks = AddBookFragment()
        when(item.itemId) {
            R.id.miAddBook ->  supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_layout, addBooks)
                commit()
            }
            R.id.miLogin ->{
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)}
        }
        return true
    }
}
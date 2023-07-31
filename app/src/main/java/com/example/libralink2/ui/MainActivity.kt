package com.example.libralink2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.libralink2.database.LibraLinkRoomDatabase
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.libralink2.R
import com.example.libralink2.repository.BooksRepository
import com.example.libralink2.ui.fragments.AddBookFragment
import com.example.libralink2.viewmodels.BooksViewModel
import com.example.libralink2.viewmodels.BooksViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController
    lateinit var viewModel: BooksViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val booksRepository = BooksRepository(LibraLinkRoomDatabase(this))
        val viewModelProviderFactory = BooksViewModelProviderFactory(booksRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(BooksViewModel::class.java)

        val bottomNavigationView :BottomNavigationView = findViewById(R.id.bottomNavigationView) // to detect the icon id
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf
                (R.id.homeFragment, R.id.messagesFragment, R.id.listsFragment, R.id.profileFragment)
        )
        setupActionBarWithNavController(navController,appBarConfiguration) // um die titel oben zu stellen

        bottomNavigationView.setupWithNavController(navController)// to marge the bottomNavigationView with fragment


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.miLogin -> {
                navController.navigate(R.id.accountFragment)
                return true
            }
            android.R.id.home -> {
                return navController.navigateUp() || super.onSupportNavigateUp()
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}

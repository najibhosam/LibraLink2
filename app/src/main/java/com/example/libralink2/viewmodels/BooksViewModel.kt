package com.example.libralink2.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.libralink2.repository.BooksRepository

class BooksViewModel(
    val booksRepository: BooksRepository
) : ViewModel() {

}

class BooksViewModelProviderFactory (
    val booksRepository: BooksRepository
        ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BooksViewModel(booksRepository) as T
    }
}
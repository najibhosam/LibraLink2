package com.example.libralink2.viewmodels

import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {
    var bookTitle: String = ""
    var bookAuthor: String = ""
    var pages: String = ""
    var coverImageUrl: String = ""
}
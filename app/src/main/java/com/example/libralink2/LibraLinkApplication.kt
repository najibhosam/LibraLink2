package com.example.libralink2

import android.app.Application
import com.example.libralink2.database.LibraLinkRoomDatabase

class LibraLinkApplication: Application() {
    val database: LibraLinkRoomDatabase by lazy { LibraLinkRoomDatabase.getDatabase(this) }
}
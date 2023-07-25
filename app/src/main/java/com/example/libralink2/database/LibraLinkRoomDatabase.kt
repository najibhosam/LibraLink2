package com.example.libralink2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class,
        BookList::class,
        Book::class,
        ListBookCrossRef::class
               ],
    version = 1, exportSchema = false
)
abstract class LibraLinkRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: LibraLinkRoomDatabase? = null

        fun getDatabase(context: Context): LibraLinkRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibraLinkRoomDatabase::class.java,
                    "libra_link_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
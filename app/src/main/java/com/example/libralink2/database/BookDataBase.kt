package com.example.libralink2.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context


@Database(entities = [Book::class], version = 1)
abstract class BookDataBase : RoomDatabase(){
    abstract fun booksDao(): BooksDao

    companion object{
        @Volatile
        private var INSTANCE : BookDataBase? = null

        fun getDatabase(context: Context): BookDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDataBase::class.java,
                    "Books_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
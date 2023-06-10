package com.example.libralink2.database

import android.content.Context
import androidx.room.*

@Database(entities = [Listen::class], version = 1)

abstract class ListDataBase:RoomDatabase(){

    abstract fun ListenDao(): ListenDao

    companion object{
        @Volatile
        private var INSTANCE : ListDataBase? = null

        fun getDatabase(context: Context): ListDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ListDataBase::class.java,
                    "List_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
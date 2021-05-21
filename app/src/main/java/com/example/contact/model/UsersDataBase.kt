package com.example.contact.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class UsersDataBase:RoomDatabase() {

    abstract fun getusersDao(): UsersDao

    companion object{
        @Volatile
        private var instance : UsersDataBase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: createDatabse(context).also{
                instance = it
            }
        }

        private fun createDatabse(context: Context) =
                Room.databaseBuilder(context.applicationContext, UsersDataBase::class.java, "UsersDataBase.db").build()
    }
}
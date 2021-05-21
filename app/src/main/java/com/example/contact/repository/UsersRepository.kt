package com.example.contact.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.contact.model.Users
import com.example.contact.model.UsersDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersRepository(context: Context) {

  private  val db = UsersDataBase.invoke(context)

  fun insert(users: Users){
    GlobalScope.launch {
      withContext(Dispatchers.IO){
        db.getusersDao().insert(users)

      }
    }


  }
  suspend fun delete(users: Users) = db.getusersDao().delete(users)

  fun allUser(): LiveData<List<Users>> = db.getusersDao().getAllUsers()

}
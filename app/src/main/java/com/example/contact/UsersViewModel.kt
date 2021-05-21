package com.example.contact

import androidx.lifecycle.ViewModel
import com.example.contact.model.Users
import com.example.contact.repository.UsersRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UsersViewModel(private val repository: UsersRepository):ViewModel() {

    fun insert(users: Users) = GlobalScope.launch {
        repository.insert(users)
    }

    fun delete(users: Users) = GlobalScope.launch {
        repository.delete(users)
    }

    fun allUsers() =repository.allUser()
}
package com.example.contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contact.repository.UsersRepository

class UsersViewModelFactory(private val repository: UsersRepository):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(repository) as T
    }
}
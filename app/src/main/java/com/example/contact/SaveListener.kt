package com.example.contact

import com.example.contact.model.Users

interface SaveListener {

    fun onSaveButtonClick(users: Users)
    fun text ()
}
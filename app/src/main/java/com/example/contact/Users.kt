package com.example.contact.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_users")
data class Users(@ColumnInfo(name = "fullName")
                 var fullName:String,
                 @ColumnInfo(name = "email")
                 var email: String,
                 @ColumnInfo(name = "password")
                 var password: String,
                 @ColumnInfo(name = "confirmPassword")
                 var confirmPassWord:String
){
    @PrimaryKey(autoGenerate  = true)
    var id:Int = 0
}
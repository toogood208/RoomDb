package com.example.contact.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(users: Users)

    @Delete
    suspend fun delete(users: Users)

    @Query("SELECT * FROM contact_users")
    fun getAllUsers(): LiveData<List<Users>>

    @Update
    fun UpdateUser(users: Users)
}
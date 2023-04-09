package com.example.githubuserinfo.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubuserinfo.model.SavedUser

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(savedUser: SavedUser)

    @Query("SELECT * FROM saved_users")
    fun getSavedUsers(): LiveData<List<SavedUser>>

}
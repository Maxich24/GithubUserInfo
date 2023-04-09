package com.example.githubuserinfo.repository

import androidx.lifecycle.LiveData
import com.example.githubuserinfo.model.SavedUser

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<SavedUser>> = userDao.getSavedUsers()

    suspend fun insertUser(user: SavedUser) {
        userDao.saveUser(user)
    }
}
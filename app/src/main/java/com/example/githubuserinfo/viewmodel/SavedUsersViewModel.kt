package com.example.githubuserinfo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuserinfo.model.SavedUser
import com.example.githubuserinfo.repository.AppDatabase
import com.example.githubuserinfo.repository.UserDao
import com.example.githubuserinfo.repository.UserRepository
import kotlinx.coroutines.launch

class SavedUsersViewModel(application: Application) : AndroidViewModel(application) {
//class SavedUsersViewModel : ViewModel() {
    private val userDao: UserDao = AppDatabase.getInstance(application).userDao()
    private val userRepository = UserRepository(userDao)

    val allUsers: LiveData<List<SavedUser>> = userRepository.allUsers

    fun insertUser(user: SavedUser) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }

    }
}
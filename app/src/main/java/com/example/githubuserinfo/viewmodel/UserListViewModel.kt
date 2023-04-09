package com.example.githubuserinfo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuserinfo.model.GithubUser
import com.example.githubuserinfo.repository.GithubUserRepository
import kotlinx.coroutines.launch

class UserListViewModel : ViewModel() {

    private val repository = GithubUserRepository()

    private val _users = MutableLiveData<List<GithubUser>>()
    val users: LiveData<List<GithubUser>> = _users

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                val users = repository.getAllUsers()
                _users.value = users
            } catch (e: Exception) {
                Log.e("exception", e.message.toString())
            }
        }
    }
}
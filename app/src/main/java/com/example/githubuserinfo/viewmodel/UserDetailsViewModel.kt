package com.example.githubuserinfo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuserinfo.model.UserDetails
import com.example.githubuserinfo.repository.GithubUserRepository
import kotlinx.coroutines.launch

class UserDetailsViewModel : ViewModel() {

    private val repository = GithubUserRepository()

    private val _userDetails = MutableLiveData<UserDetails>()
    val userDetails: LiveData<UserDetails> = _userDetails

    fun getUserDetails(login: String) {
        viewModelScope.launch {
            try {
                val details = repository.getUserDetails(login)
                _userDetails.value = details
            } catch (e: Exception) {
                Log.e("exception", e.message.toString())
            }
        }
    }
}
package com.example.githubuserinfo.repository

import com.example.githubuserinfo.model.GithubUser
import com.example.githubuserinfo.model.UserDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {

    @GET("users")
    suspend fun getAllUsers(): List<GithubUser>

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): UserDetails
}
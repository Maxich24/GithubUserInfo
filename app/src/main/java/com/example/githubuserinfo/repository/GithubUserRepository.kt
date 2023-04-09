package com.example.githubuserinfo.repository

import com.example.githubuserinfo.model.GithubUser
import com.example.githubuserinfo.model.UserDetails
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GithubUserRepository {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val apiService = retrofit.create(GithubApiService::class.java)

    suspend fun getAllUsers(): List<GithubUser> {
        return apiService.getAllUsers()
    }

    suspend fun getUserDetails(login: String): UserDetails {
        return apiService.getUserDetails(login)
    }
}
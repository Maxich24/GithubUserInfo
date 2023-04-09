package com.example.githubuserinfo.model

import com.squareup.moshi.Json

data class GithubUser(
    @Json(name = "login") val login: String,
    @Json(name = "id") val id: Int,
    @Json(name = "avatar_url") val avatarUrl: String
)
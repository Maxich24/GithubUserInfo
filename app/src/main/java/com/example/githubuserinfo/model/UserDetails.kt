package com.example.githubuserinfo.model

import com.squareup.moshi.Json

data class UserDetails(
    val id: Int,
    @Json(name = "avatar_url") val avatarUrl: String,
    val name: String?,
    val type: String?,
    val email: String?,
    val company: String?,
    val following: Int?,
    val followers: Int?,
    @Json(name = "created_at") val createdDate: String?
)
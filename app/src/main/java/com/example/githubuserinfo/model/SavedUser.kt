package com.example.githubuserinfo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "saved_users")
data class SavedUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val email: String?,
    @Json(name = "avatar_url") val avatarUrl: String?
)
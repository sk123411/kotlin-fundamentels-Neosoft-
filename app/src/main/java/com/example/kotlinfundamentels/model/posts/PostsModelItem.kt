package com.example.kotlinfundamentels.model.posts

import com.google.gson.annotations.SerializedName

data class PostsModelItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)
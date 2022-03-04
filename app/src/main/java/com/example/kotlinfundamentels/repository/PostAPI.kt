package com.example.kotlinfundamentels.repository

import com.example.kotlinfundamentels.model.posts.PostsModel
import retrofit2.Call
import retrofit2.http.GET




interface PostAPI {

    @GET("posts")
    fun getPosts(): Call<PostsModel?>







}
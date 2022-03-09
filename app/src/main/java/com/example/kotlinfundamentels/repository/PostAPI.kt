package com.example.kotlinfundamentels.repository

import com.example.kotlinfundamentels.model.commets.CommentsResponse
import com.example.kotlinfundamentels.model.posts.PostsModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET




interface PostAPI {

    @GET("posts")
    fun getPosts(): Call<PostsModel?>


    @GET("posts")
    fun getRXPosts(): Observable<PostsModel?>


    @GET("comments")
    fun getRXComments(): Observable<CommentsResponse>

}
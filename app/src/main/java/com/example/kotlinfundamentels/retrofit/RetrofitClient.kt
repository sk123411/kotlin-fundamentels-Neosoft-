package com.example.kotlinfundamentels.retrofit

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.OkHttpClient




object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {

        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }


}
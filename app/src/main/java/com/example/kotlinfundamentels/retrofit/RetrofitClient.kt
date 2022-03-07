package com.example.kotlinfundamentels.retrofit

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {

        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun getRXClient(): Retrofit? {

        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit
    }
}
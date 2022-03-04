package com.example.kotlinfundamentels.repository.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinfundamentels.R
import com.example.kotlinfundamentels.model.posts.PostsModel
import com.example.kotlinfundamentels.repository.PostAPI
import com.example.kotlinfundamentels.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import kotlin.random.Random

class MainActivityViewModel:ViewModel() {


    private val mutablePostList=MutableLiveData<PostsModel>()

    val postList :LiveData<PostsModel> = mutablePostList





    var imagesList = listOf<Int>(R.drawable.pup_one,R.drawable.pup_two,R.drawable.pup_three,
    R.drawable.pup_four,R.drawable.pup_fve,R.drawable.pup_six,R.drawable.pup_sven,
    R.drawable.pup_eight,R.drawable.pup_nine,R.drawable.pup_ten);




    fun getImage():Int{

        return imagesList[Random.nextInt(imagesList.size)]
    }



    fun getPosts(){
        var postAPI = RetrofitClient.getClient()!!.create(PostAPI::class.java)

        postAPI.getPosts().enqueue(object :retrofit2.Callback<PostsModel?> {
            override fun onResponse(call: Call<PostsModel?>?, response: Response<PostsModel?>?) {

                mutablePostList.value = response!!.body()
            }

            override fun onFailure(call: Call<PostsModel?>?, t: Throwable?) {

            }


        })

    }



}
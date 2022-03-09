package com.example.kotlinfundamentels.repository.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinfundamentels.R
import com.example.kotlinfundamentels.model.CustomPost
import com.example.kotlinfundamentels.model.commets.CommentsResponse
import com.example.kotlinfundamentels.model.posts.PostsModel
import com.example.kotlinfundamentels.repository.PostAPI
import com.example.kotlinfundamentels.retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {


    private val mutablePostList = MutableLiveData<PostsModel>()

    val postList: LiveData<PostsModel> = mutablePostList


    private val mutableLoading = MutableLiveData<Boolean>()

    val loading: LiveData<Boolean> = mutableLoading


    var imagesList = listOf<Int>(
        R.drawable.pup_one, R.drawable.pup_two, R.drawable.pup_three,
        R.drawable.pup_four, R.drawable.pup_fve, R.drawable.pup_six, R.drawable.pup_sven,
        R.drawable.pup_eight, R.drawable.pup_nine, R.drawable.pup_ten
    );


    fun getImage(): Int {

        return imagesList[Random.nextInt(imagesList.size)]
    }


    fun getPosts() {
        mutableLoading.value = true

        var postAPI = RetrofitClient.getClient()!!.create(PostAPI::class.java)

        //VIEWMODEL SCOPE AUTOMATICALLY SUSPENDS WHEN VIEWMODEL CLEARED
        viewModelScope.launch {

            postAPI.getPosts().enqueue(object : retrofit2.Callback<PostsModel?> {
                override fun onResponse(
                    call: Call<PostsModel?>?,
                    response: Response<PostsModel?>?
                ) {
                    mutableLoading.value = false

                    mutablePostList.value = response!!.body()
                }

                override fun onFailure(call: Call<PostsModel?>?, t: Throwable?) {

                }


            })
        }


    }

    @SuppressLint("CheckResult")
    fun getRXPosts() {

        mutableLoading.value = true

        //RXJAVA IMPLEMENTATION OF GET POST API WITH OBSERVABLE IN USE

        var postAPI = RetrofitClient.getRXClient()!!.create(PostAPI::class.java)


        postAPI.getRXPosts().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe {

                mutableLoading.value = false
                mutablePostList.value = it

            }


    }


    fun getPostAndComments() {

        var ob1 = Observable.just("item1","item2")
        var ob2 = Observable.just("item3","item4")


        Observable.zip(ob1,ob2,object: BiFunction< String,  String,  Any>{
            override fun apply(t1: String, t2: String): Any {

                var combineObject = t1 + ":"+t2
//                Log.d("pppp", combineObject)

                return combineObject


            }

        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe {

            Log.d("pppp", it.toString())


        }


    }


}
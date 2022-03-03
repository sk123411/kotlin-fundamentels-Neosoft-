package com.example.kotlinfundamentels.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlinfundamentels.R
import kotlin.random.Random

class MainActivityViewModel:ViewModel() {


    var imagesList = listOf<Int>(R.drawable.pup_one,R.drawable.pup_two,R.drawable.pup_three,
    R.drawable.pup_four,R.drawable.pup_fve,R.drawable.pup_six,R.drawable.pup_sven,
    R.drawable.pup_eight,R.drawable.pup_nine,R.drawable.pup_ten);




    fun getImage():Int{

        return imagesList[Random.nextInt(imagesList.size)]
    }



}
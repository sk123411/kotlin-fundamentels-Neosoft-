package com.example.kotlinfundamentels.run_kotlin

import android.util.Log
import com.example.kotlinfundamentels.TAG

class Run {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val numbersMap = mapOf("key1" to "1", "key2" to 2, "key3" to 3, "key4" to 1)


//            numbersMap.values.forEach {
//                println("Hello! ${it}")
//
//
//            }



            var uniqueNums= setOf<Int>(8,8,9,9,9)

            for (u in uniqueNums){
                println("Unique Nums: ${u}")
            }


            val numbers = listOf("one", "two", "three", "four", "five")

            println(numbers.groupBy { it.first().uppercase() })





        }
    }




}
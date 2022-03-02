package com.example.kotlinfundamentels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinfundamentels.model.Person


const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //var and val // const val
        testVarVal()

    }

    private fun testVarVal() {

        //USAGE OF CONST AND DEFINES COMPILE TIME CONSTANT
        Log.d(TAG, " CONST VALUE.........")

        //USAGE OF VAR
        var name: String? = "Shubh Noriya"
        Log.d(TAG, " VAR VALUE.........${name}")

        //VAR DEFINES MUTABLE PROPERTY
        name = "Raja Noriya"

        Log.d(TAG, " VAR VALUE.........${name}")

        //USAGE OF VAL
        val vName: String = "Shubh Noriya"

        //VAL DEFINES IMMUTABLE PROPERTY THUS VALUE CANNOT BE CHANGED
        Log.d(TAG, " VAL VALUE.........${vName}")


    }


    fun testScopeFun() {

        //USAGE OF APPLY AND ALSO FUNCTION
        var person = Person(name = "Raju", age = 22, marriedStatus = "Single").apply {

            age = 33
            marriedStatus = "Married"
        }.also {

            Log.d(TAG, "Updated Age and Married Status ${it.age} ${it.marriedStatus}")

        }

        //USAGE OF LET FUNCTION
        var letPerson = person.let {

            it.name = "Vinay"

        }

        var runPerson = person.run {


        }

    }


    //Kotlin Collection and Different types of LOOPS
    fun testKotlinCollections() {

        //Mutable or changeble list
        var nameList = mutableListOf<String>("shivam", "khushi", "dhiraj", "virar")
        nameList.add("vijay")


        //For each Loop in kotlin and where default it represet single element
        nameList.forEach {

            Log.d(TAG, "Names are: ${it}")
        }


        val noChangenameList = listOf<String>("shivam", "khushi", "dhiraj", "virar")

        //DATA CHANGE NOT POSSIBLE IN IMMUTABLE LIST
        //noChangenameList.add("vijay")

        //FETCH DATA POSSIBLE IN IMMUTABLE LIST
        noChangenameList.get(2)

        Log.d(TAG, "Name: ${noChangenameList.get(2)}")


        //SET IN KOTLIN
        var uniqueNums = setOf<Int>(8, 8, 9, 9, 9)
        //AS IT IS SET NO DUPLICATES WILL PRINT
        for (u in uniqueNums) {
            Log.d(TAG, "Unique Nums: ${u}")
        }



        //Map in kotlin ,the type of values change automatically when use
        // INT value to String value,

        val numbersMap = mutableMapOf("key1" to "1", "key2" to 2, "key3" to 3, "key4" to 1)

        numbersMap.values.forEach {
            println("Hello! ${it}")


        }


        // MutableMap is a Map with map write operations, for example,
        // you can add a new key-value pair or update the value associated with the given key
        numbersMap.put("key1", "po")


        //TYPE OF RANGE ITERATION LOOP
        for (i in 1..4) println(i)


        //To iterate numbers in reverse order, use the downTo function instead of ...
        for (i in 4 downTo 1) print(i)


        //List sum of  function multiply 2 to each element
        // and then add all the result
        val numbers = listOf(5, 42, 10, 4)
        val min3Remainder = numbers.sumOf { it * 2 }
        println(min3Remainder)






    }


}
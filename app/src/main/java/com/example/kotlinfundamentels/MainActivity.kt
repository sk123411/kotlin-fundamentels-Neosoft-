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
        var name:String?= "Shubh Noriya"
        Log.d(TAG, " VAR VALUE.........${name}")

        //VAR DEFINES MUTABLE PROPERTY
        name = "Raja Noriya"

        Log.d(TAG, " VAR VALUE.........${name}")

        //USAGE OF VAL
        val vName:String = "Shubh Noriya"

        //VAL DEFINES IMMUTABLE PROPERTY THUS VALUE CANNOT BE CHANGED
        Log.d(TAG, " VAL VALUE.........${vName}")





    }



    fun testScopeFun(){

        //USAGE OF APPLY AND ALSO FUNCTION
        var person = Person(name = "Raju",age = 22,marriedStatus = "Single").apply {

            age=33
            marriedStatus="Married"
        }.also {

            Log.d(TAG, "Updated Age and Married Status ${it.age} ${it.marriedStatus}")

        }

        //USAGE OF LET FUNCTION
        var letPerson=person.let {

            it.name="Vinay"

        }

       var runPerson= person.run {



        }

    }
}
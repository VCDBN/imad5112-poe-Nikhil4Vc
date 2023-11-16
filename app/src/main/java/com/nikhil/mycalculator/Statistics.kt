package com.nikhil.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.StringBuilder

class Statistics : AppCompatActivity() {

    //declare variables
    lateinit var InputNumber: EditText
    lateinit var NumbersStored: TextView

    //Create a variable to store the array, set the array to 0
    var arr:ArrayList<Int> = ArrayList(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        //Gain access to variables
        var btnAddNum = findViewById<Button>(R.id.btnAddNum)
        var btnStatsClear = findViewById<Button>(R.id.btnStatsClear)
        var btnStatsAverage = findViewById<Button>(R.id.btnStatsAverage)
        var btnStatsMinMax = findViewById<Button>(R.id.btnStatsMinMax)

        var txtStatsAverageAnswer = findViewById<TextView>(R.id.txtStatsAverageAnswer)
        var txtStatsMinMaxAnswer = findViewById<TextView>(R.id.txtStatsMinMaxAnswer)

        //Gain access to components
        InputNumber = findViewById(R.id.edtStatsNumber)
        NumbersStored = findViewById(R.id.txtStatsNumbers)

        //Set on click listener for Add button to add numbers to the array
        btnAddNum.setOnClickListener {
            val NumOne = InputNumber.text.toString()

            //Add logic using if statements
            if (NumOne.isBlank()) {
                Toast.makeText(this, "No Number! Please enter a Number", Toast.LENGTH_SHORT).show()
                Log.e("Error", "input is not entered") //Keep track of errors
            } else if (arr.size != 10) {
                btnAddNum(NumOne.toInt()) //addition button is a function below
                InputNumber.text.clear()
            } else if (arr.size == 10) {
                Toast.makeText(this, "Maximum number limit reached", Toast.LENGTH_SHORT).show()
            }

        }

        //Set on click listener for clear button to clear the array
        btnStatsClear.setOnClickListener {
            //Create a variable to clear the input field and display a message if no numbers are entered
            val Num1 = InputNumber.text.toString()

            if (arr.size == 0) {
                Toast.makeText(this, "Please fill the array", Toast.LENGTH_SHORT).show()
            } else {
                arr.clear()
                InputNumber.text.clear()
                NumbersStored.text = ""
                txtStatsAverageAnswer.setText("")
                txtStatsMinMaxAnswer.setText("")
            }
        }

        btnStatsAverage.setOnClickListener {
            var SumStats = arr.sum() //Sum of all numbers in the array
            var size = arr.size //Get the number of numbers in the array
            var AnswerStats = SumStats/size //Get the average answer

            txtStatsAverageAnswer.setText("Average: $AnswerStats")

        }

        btnStatsMinMax.setOnClickListener {
           var MinAnswer = arr.min()
            var MaxAnswer = arr.max()

            txtStatsMinMaxAnswer.setText("Min: $MinAnswer"+" "+"Max: $MaxAnswer")
        }

    }

    fun btnAddNum(NumberOne: Int){
        arr.add(NumberOne) //add to the array

        val Str= StringBuilder()
        //StringBuilder is used for efficiently creating strings,
        // especially when you need to concatenate multiple strings together.

        for (x in arr) {
            //this is a loop that integrates through each element x in the arr list.
            NumbersStored.text="${Str.append(x).append(", ")}"

            //It appends a comma and a space to separate the values in the string.
        }
    }

}
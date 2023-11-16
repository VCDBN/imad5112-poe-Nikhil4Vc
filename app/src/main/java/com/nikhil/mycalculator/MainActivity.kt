package com.nikhil.mycalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.sqrt

//ST10315122 Nikhil Rajkumar
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //First gain access to components
        var edtTextNumber1 = findViewById<EditText>(R.id.edtTextNumber1)
        var edtTextNumber2 = findViewById<EditText>(R.id.edtTextNumber2)

        var edtTextMainAnswer = findViewById<TextView>(R.id.edtTextMainAnswer)

        var edtTextError = findViewById<TextView>(R.id.edtTextError)


        //Gain access to component
        var btnAddition = findViewById<Button>(R.id.btnAddition)
        //Set a Onclick event with the button
        btnAddition.setOnClickListener {

            //Make variables for the 2 numbers used
            var Number1 : Int = edtTextNumber1.text.toString().toInt()
            var Number2 : Int = edtTextNumber2.text.toString().toInt()

            //Clears error message
            edtTextError.text = ""

            //Process the inputs to get an answer
            var additionAnswer = Number1 + Number2

            //Display the answer
            edtTextMainAnswer.text = String.format("$Number1"+"+"+"$Number2"+"="+"$additionAnswer")

        }

        //Gain access to component
        var btnSubtraction = findViewById<Button>(R.id.btnSubtraction)
        //Set a Onclick event with the button
        btnSubtraction.setOnClickListener {

            //Make variables for the 2 numbers used
            var Number1 : Int = edtTextNumber1.text.toString().toInt()
            var Number2 : Int = edtTextNumber2.text.toString().toInt()

            //Clears error message
            edtTextError.text = ""

            //Process the inputs to get an answer
            var SubtractionAnswer = Number1 - Number2

            //Display the answer
            edtTextMainAnswer.text = String.format("$Number1"+"-"+"$Number2"+"="+"$SubtractionAnswer")

        }

        //Gain access to component
        var btnMultiplication = findViewById<Button>(R.id.btnMultiplication)
        //Set a Onclick event with the button
        btnMultiplication.setOnClickListener {

            //Make variables for the 2 numbers used
            var Number1 : Int = edtTextNumber1.text.toString().toInt()
            var Number2 : Int = edtTextNumber2.text.toString().toInt()

            //Clears error message
            edtTextError.text = ""

            //Process the inputs to get an answer
            var MultiplicationAnswer = Number1 * Number2

            //Display the answer
            edtTextMainAnswer.text = String.format("$Number1"+"×"+"$Number2"+"="+"$MultiplicationAnswer")

        }

        //Gain access to component
        var btnDivision = findViewById<Button>(R.id.btnDivision)
        //Set a Onclick event with the button
        btnDivision.setOnClickListener {

            //Make variables for the 2 numbers used
            var Number1 : Int = edtTextNumber1.text.toString().toInt()
            var Number2 : Int = edtTextNumber2.text.toString().toInt()

            //If statement used for error checking
            if (Number2 >= 1) {
                //Clears error message
                edtTextError.text = ""

                //Process the inputs to get an answer
                var DivisionAnswer = Number1 / Number2

                //Display the answer
                edtTextMainAnswer.text = String.format("$Number1"+"÷"+"$Number2"+"="+"$DivisionAnswer")
            } else {
                //Clears the Answer field
                edtTextMainAnswer.text = ""
                //Displays error message
                edtTextError.text = "Error: The second number can not be 0 in division"
            }
        }

        //Gain access to component
       var btnSquareRoot = findViewById<Button>(R.id.btnSquareRoot)
        //Set a Onclick event with the button
        btnSquareRoot.setOnClickListener {

            //Make variables for the 2 numbers used
            var Number1 : Int = edtTextNumber1.text.toString().toInt()

            if (Number1 < 0){
                //Clears error message
                edtTextError.text = ""

                //Process the inputs to get an answer
                var SquareRootAnswer = sqrt(Number1.toDouble())

                //Display the answer
                edtTextMainAnswer.text = String.format("Sqrt($Number1)"+"="+"$SquareRootAnswer"+"i")
            } else {
                //Clears error message
                edtTextError.text = ""

                //Process the inputs to get an answer
                var SquareRootAnswer = sqrt(Number1.toDouble())

                //Display the answer
                edtTextMainAnswer.text = String.format("Sqrt($Number1)"+"="+"$SquareRootAnswer")
            }

        }

        //Gain access to component
        var btnPower = findViewById<Button>(R.id.btnPower)
        //Set a Onclick event with the button
        btnPower.setOnClickListener {

            //Make variables for the 3 numbers used
            var Number1: Int = edtTextNumber1.text.toString().toInt()
            var Number2: Int = edtTextNumber2.text.toString().toInt()
            var Number2Display: Int = Number2
            var PowerAnswer: Long = 1

            //Clears error message
            edtTextError.text = ""

            //While loop used for calculations
            while (Number2 != 0) {
                PowerAnswer *= Number1.toLong()
                --Number2

                //Display Power Answer
                edtTextMainAnswer.text =
                    String.format("$Number1" + "^" + "$Number2Display" + "=" + "$PowerAnswer")
            }
        }

        //Gain access to component
        var btnStatistics = findViewById<Button>(R.id.btnStatistics)
        //Set Onclick listener
        btnStatistics.setOnClickListener {
                val Intent = Intent(this,Statistics::class.java)
                startActivity(Intent)

        }

        }




}
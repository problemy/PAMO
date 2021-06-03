package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.HomeActivity

class HomeActivity : AppCompatActivity() {


    var resulttext: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val weightEt = findViewById<EditText>(R.id.weight)
        val  heightEt = findViewById<EditText>(R.id.height)
        val weight = weightEt.text.toString()
        val height = heightEt.text.toString()
        resulttext = findViewById<TextView>(R.id.result)
        val bmrButton = findViewById<Button>(R.id.bmrcalc)


    bmrButton.setOnClickListener(){

        val BMRIntent = Intent(
            this@HomeActivity,
            BmrCalculator::class.java
        )

        intent.putExtra("BmiResult", bMIresult)
        intent.putExtra("Weight", weight)
        intent.putExtra("Height", height)
        startActivity(BMRIntent)
    }

    }
    fun gotoQuiz() {
        val QuizIntent = Intent(this@HomeActivity, Quiz::class.java)
        startActivity(QuizIntent)
    }


        var weight: EditText? = null
            private set
        var height: EditText? = null
            private set
        private var calculation: String? = null
        var bMIresult: String? = null
            private set

        fun calculateBMI(homeActivity: HomeActivity) {
            val w = weight!!.text.toString()
            val h = height!!.text.toString()
            val weightValue: Float = w.toFloat()

            val heightValue: Float = h.toFloat() / 100
            val bmi = weightValue / (heightValue * heightValue)
            if (bmi < 18.5) {
                bMIresult = "Underweight"
            } else if (bmi < 25) {
                bMIresult = "Healthy Weight"
            } else if (bmi < 30) {
                bMIresult = "Overweight"
            } else if (bmi > 30) {
                bMIresult = "Obese"
            }
            calculation = """
                Result:
                $bmi
                $bMIresult
                """.trimIndent()
            homeActivity.resulttext!!.text = calculation
        }


}


package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.R.id.bmrcalc
import com.example.bmicalculator.R.id.calculateBMR


class BmrCalculator : AppCompatActivity() {

    var weight: EditText? = null
    var height: EditText? = null
    var bmiResult: String? = intent.getStringExtra("BmiResult")
    var dish: String? = null
    var dishprop: String? = null
    var a: EditText? = null
    var bmr = 0f
    var result: TextView? = null
    var resultDish: TextView? = null
    var calculation: String? = null
     var bmrButton: Button? = null
    var radioGender: RadioGroup? = null
    var gender: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmr_calculator)
        a = findViewById(R.id.age)
        result = findViewById(R.id.result)
        resultDish = findViewById(R.id.resultDish)
         val bmrcalcButton = findViewById<Button>(R.id.calculateBMR)

        bmrcalcButton.setOnClickListener(){
            val weightt: Float = weight.toString().toFloat()
            val heightt: Float = height.toString().toFloat()
            val age: Int = a!!.text.toString().toInt()
            if (gender === "m") {
                bmr = 66 + 13.7f * weightt + 5 * heightt - 6.8f * age
            } else if (gender === "f") {
                bmr = 655 + 9.6f * weightt + 1.8f * heightt - 4.7f * age
            } else {
                calculation = "Check your gender"
                bmr = 2f
            }
            calculation = "BMR = " + String.format("%,.2f", bmr)
            if (weightt <= 0.0f || heightt <= 0.0f) {
                calculation = "Calculate BMI first"
            }
            propositeRecipe()
            result!!.text = calculation

        }
    }

    fun onRadioButtonClicked(v: View) {
        when (v.id) {
            R.id.male -> gender = "m"
            R.id.female -> gender = "f"
        }
    }




    fun propositeRecipe() {
        dish = when (bmiResult) {
            "Underweight" -> "Kebab"
            "Healthy Weight" -> "Eat what you want"
            "Overweight" -> "Chicken with rice"
            "Obese" -> "Mixed Salad"
            else -> "Error"
        }
        dishprop = "Dinner proposition:$dish"
        resultDish!!.text = dishprop
    }

    fun gotoQuiz() {
        val QuizIntent = Intent(this@BmrCalculator, Quiz::class.java)
        startActivity(QuizIntent)
    }

}
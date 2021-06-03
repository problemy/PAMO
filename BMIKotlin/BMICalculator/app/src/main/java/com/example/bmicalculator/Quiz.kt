package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.Quiz

class Quiz : AppCompatActivity() {
    var answer1: Button? = null
    var answer2: Button? = null
    var answer3: Button? = null
    var answer4: Button? = null
    var chartButton: Button? = null
    var question: TextView? = null
    var score: TextView? = null
    private val aQuestions = Questions()
    private var cAnswer: String? = null
    private var cScore = 0
    private val aQuestionsLength = aQuestions.aQuestions.size
    private var questionNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val chartButton = findViewById(R.id.covidChart) as Button
        chartButton.setVisibility(View.GONE)
        val  score = findViewById(R.id.score) as TextView
        score.setVisibility(View.GONE)
        val answer1 = findViewById(R.id.answer1) as Button
        val answer2 = findViewById(R.id.answer2) as Button
        val answer3 = findViewById(R.id.answer3) as Button
        val answer4 = findViewById(R.id.answer4) as Button
        question = findViewById(R.id.question)
        updateQuestion(questionNumber)
        answer1.setOnClickListener(View.OnClickListener {
            if (answer1.getText() === cAnswer) {
                cScore++
            }
            //  score.setText("Score:"+ cScore);
            questionNumber++
            updateQuestion(questionNumber)
        })
        answer2.setOnClickListener(View.OnClickListener {
            if (answer2.getText() === cAnswer) {
                cScore++
            }
            //   score.setText("Score:"+ cScore);
            questionNumber++
            updateQuestion(questionNumber)
        })
        answer3.setOnClickListener(View.OnClickListener {
            if (answer3.getText() === cAnswer) {
                cScore++
            }
            // score.setText("Score:"+ cScore);
            questionNumber++
            updateQuestion(questionNumber)
        })
        answer4.setOnClickListener(View.OnClickListener {
            if (answer4.getText() === cAnswer) {
                cScore++
            }
            // score.setText("Score:"+ cScore);
            questionNumber++
            updateQuestion(questionNumber)
        })
    }

    private fun updateQuestion(num: Int) {
        if (questionNumber < aQuestionsLength) {
            question!!.text = aQuestions.getQuestion(num)
            answer1!!.text = aQuestions.getChoice1(num)
            answer2!!.text = aQuestions.getChoice2(num)
            answer3!!.text = aQuestions.getChoice3(num)
            answer4!!.text = aQuestions.getChoice4(num)
            cAnswer = aQuestions.getCorrectAnswer(num)
        } else {
            chartButton!!.visibility = View.VISIBLE
            score!!.visibility = View.VISIBLE
            answer1!!.visibility = View.GONE
            answer2!!.visibility = View.GONE
            answer3!!.visibility = View.GONE
            answer4!!.visibility = View.GONE
            question!!.text = "Congratulaations!"
            score!!.text = "Your Score:$cScore"
        }
    }

    fun gotoCovidChart(view: View?) {
        val CovidChartIntent = Intent(this@Quiz, CovidChart::class.java)
        startActivity(CovidChartIntent)
    }
}
package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

;import java.util.Random;

public class Quiz extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4,chartButton ;
    TextView question, score;

    private Questions aQuestions = new Questions();
    private String cAnswer;
    private int cScore =0;
    private int  aQuestionsLength = aQuestions.aQuestions.length;
   private  int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        chartButton = findViewById(R.id.covidChart);
        chartButton.setVisibility(View.GONE);
        score = findViewById(R.id.score);
        score.setVisibility(View.GONE);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        question = findViewById(R.id.question);


        updateQuestion(questionNumber);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText() == cAnswer){
                    cScore++;
                }
              //  score.setText("Score:"+ cScore);
                questionNumber++;
                updateQuestion(questionNumber);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText() == cAnswer){
                    cScore++;
                }
             //   score.setText("Score:"+ cScore);
                questionNumber++;
                updateQuestion(questionNumber);

            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText() == cAnswer){
                    cScore++;
                }
               // score.setText("Score:"+ cScore);
                questionNumber++;
                updateQuestion(questionNumber);
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getText() == cAnswer){
                    cScore++;
                }
               // score.setText("Score:"+ cScore);
                questionNumber++;
                updateQuestion(questionNumber);
            }
        });
    }

    private void updateQuestion(int num) {

        if (questionNumber  < aQuestionsLength) {
            question.setText(aQuestions.getQuestion(num));
            answer1.setText(aQuestions.getChoice1(num));
            answer2.setText(aQuestions.getChoice2(num));
            answer3.setText(aQuestions.getChoice3(num));
            answer4.setText(aQuestions.getChoice4(num));
            cAnswer = aQuestions.getCorrectAnswer(num);
        }
        else{
            chartButton.setVisibility(View.VISIBLE);
            score.setVisibility(View.VISIBLE);
            answer1.setVisibility(View.GONE);
            answer2.setVisibility(View.GONE);
            answer3.setVisibility(View.GONE);
            answer4.setVisibility(View.GONE);

            question.setText("Congratulaations!");
            score.setText("Your Score:"+ cScore);
        }



    }

    public void gotoCovidChart(View view) {
        Intent CovidChartIntent = new Intent(Quiz.this, CovidChart.class);
           startActivity(CovidChartIntent);
    }

}
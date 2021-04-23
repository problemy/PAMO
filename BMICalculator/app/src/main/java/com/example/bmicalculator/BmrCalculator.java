package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BmrCalculator extends AppCompatActivity {

    EditText weight, height;
    String bmiResult = HomeActivity.getBMIresult();
    String dish,dishprop;
    EditText a;
    float bmr = 0;
    TextView result,resultDish;
    String calculation;
    private Button bmrButton;
    RadioGroup radioGender;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_calculator);
        a = findViewById(R.id.age);
        result = findViewById(R.id.result);
        resultDish = findViewById(R.id.resultDish);



    }
    public void onRadioButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.male:
                gender = "m";
                break;
            case R.id.female:
                gender = "f";
                break;
        }
    }
    public void calculateBMR(View view) {
        float weight = Float.parseFloat(HomeActivity.getWeight().getText().toString());
        float height = Float.parseFloat(HomeActivity.getHeight().getText().toString());
        int age = Integer.parseInt(a.getText().toString());

        if (gender == "m") {
            bmr = 66 + (13.7f * weight) + (5 * height) - (6.8f * age);
        } else if (gender == "f") {
            bmr = 655 + (9.6f * weight) + (1.8f * height) - (4.7f * age);
        } else {
            calculation = "Check your gender";
            bmr = 2;
        }

        calculation = "BMR = " + String.format("%,.2f", bmr);
        if (weight <= 0.0f || height <= 0.0f) {
            calculation = "Calculate BMI first";
        }

        propositeRecipe();
        result.setText(calculation);
    }

    public void propositeRecipe() {
        switch (bmiResult) {
            case "Underweight":
                dish = "Kebab";
                break;
            case "Healthy Weight":
                dish = "Eat what you want";
                break;
            case "Overweight":
                dish = "Chicken with rice";
                break;
            case "Obese":
                dish = "Mixed Salad";
                break;
            default:
                dish = "Error";
        }

        dishprop = "Dinner proposition:"+dish;
      resultDish.setText(dishprop);
    }


    public void gotoQuiz(View view) {
        Intent QuizIntent = new Intent(BmrCalculator.this, Quiz.class);
        startActivity(QuizIntent);

    }
}
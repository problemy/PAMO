package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        EditText weight, height;
        TextView resulttext;
        String calculation, BMIresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resulttext = findViewById(R.id.result);

    }

    public void calculateBMI(View view) {
        String w = weight.getText().toString();
        String h = height.getText().toString();

        float weightValue = Float.parseFloat(w);
        float heightValue = Float.parseFloat(h)/100;

        float bmi = (weightValue / (heightValue * heightValue ));

        if(bmi<18.5) {
            BMIresult = "Underweight";
        }
        else if(bmi<25){
            BMIresult = "Healthy Weight";
        }
        else if(bmi<30){
            BMIresult = "Overweight";
        }
        else if(bmi>30){
            BMIresult = "Obese";
        }

        calculation = "Result:\n" +bmi+ "\n" +BMIresult;

        resulttext.setText(calculation);
    }
}
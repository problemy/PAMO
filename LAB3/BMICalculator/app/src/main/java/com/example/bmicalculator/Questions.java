package com.example.bmicalculator;

import android.content.Intent;
import android.view.View;

public class Questions {

    public String aQuestions[] = {

            "What year did the first case of SARS-CoV-2 diagnosed?",
            "One  of Coronavirus vaccines:",
            "The incorrect symptom of Covid-19 is:",
            "Can the coronavirus cause death?",
            "Where was the first case of coronavirus diagnosed?",
            "What the first person diagnosed with coronavirus probably ate?"
    };

    private String aChoices[][] = {
            {"997","2021","2019","1945"},
            {"AstraZeneca","Superleague","Primavera","Orsay"},
            {"dry cough","muscle aches","fever","superhuman strength"},
            {"Yes","No","No, if you wear a mask","Only if you are  a muggle"},
            {"Poland","China","Israel","Belarus"},
            {"schnitzel","bat","dinosaur","human"}

    };
    private String correctAnswer[] = {
            "2019","AstraZeneca","superhuman strength","Yes","China","bat"
    };
    public String getQuestion(int a) {
        String question = aQuestions[a];
        return question;
    }
    public String getChoice1(int a) {
        String choice = aChoices[a][0];
        return choice;
    }
    public String getChoice2(int a) {
        String choice = aChoices[a][1];
        return choice;
    }
    public String getChoice3(int a) {
        String choice = aChoices[a][2];
        return choice;
    }
    public String getChoice4(int a) {
        String choice = aChoices[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a) {
        String cAnswer= correctAnswer[a];
        return cAnswer;
    }

}

package com.example.bmicalculator

class Questions {
    var aQuestions = arrayOf(
            "What year did the first case of SARS-CoV-2 diagnosed?",
            "One  of Coronavirus vaccines:",
            "The incorrect symptom of Covid-19 is:",
            "Can the coronavirus cause death?",
            "Where was the first case of coronavirus diagnosed?",
            "What the first person diagnosed with coronavirus probably ate?"
    )
    private val aChoices = arrayOf(arrayOf("997", "2021", "2019", "1945"), arrayOf("AstraZeneca", "Superleague", "Primavera", "Orsay"), arrayOf("dry cough", "muscle aches", "fever", "superhuman strength"), arrayOf("Yes", "No", "No, if you wear a mask", "Only if you are  a muggle"), arrayOf("Poland", "China", "Israel", "Belarus"), arrayOf("schnitzel", "bat", "dinosaur", "human"))
    private val correctAnswer = arrayOf(
            "2019", "AstraZeneca", "superhuman strength", "Yes", "China", "bat"
    )

    fun getQuestion(a: Int): String {
        return aQuestions[a]
    }

    fun getChoice1(a: Int): String {
        return aChoices[a][0]
    }

    fun getChoice2(a: Int): String {
        return aChoices[a][1]
    }

    fun getChoice3(a: Int): String {
        return aChoices[a][2]
    }

    fun getChoice4(a: Int): String {
        return aChoices[a][3]
    }

    fun getCorrectAnswer(a: Int): String {
        return correctAnswer[a]
    }
}
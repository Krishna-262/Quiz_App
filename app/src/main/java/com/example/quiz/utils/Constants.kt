package com.example.quiz.utils

import android.widget.Toast
import com.example.quiz.Question
import com.example.quiz.R

object Constants {
    const val USER_NAME = "Quiz_app_username"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"
    fun getQuestions() : MutableList<Question>{
        val questions = mutableListOf<Question>()

        val ques1 = Question(
            1,
            "How many players are there in a cricket team ?",
            R.drawable.q1,
            "10",
            "11",
            "12",
            "15",
            2
        )
        questions.add(ques1)

        val ques2 = Question(
            2,
            "What is the shape of a cricket ball?",
            R.drawable.q2,
            "Round",
            "Oval",
            "Square",
            "Cylinder",
            1
        )
        questions.add(ques2)

        val ques3 = Question(
            3,
            "How many stumps are there in a wicket?",
            R.drawable.q3,
            "2",
            "3",
            "4",
            "5",
            2
        )
        questions.add(ques3)

        val ques4 = Question(
            4,
            "How many overs are there in a One Day International (ODI) match?",
            R.drawable.q4,
            "20",
            "40",
            "50",
            "60",
            3
        )
        questions.add(ques4)

        val ques5 = Question(
            5,
            "Who is known as the 'God of Cricket'?",
            R.drawable.q5,
            "Virat Kohli",
            "MS Dhoni",
            "Sachin Tendulkar",
            "Ricky Ponting",
            3
        )
        questions.add(ques5)

        val ques6 = Question(
            6,
            "Which country won the first Cricket World Cup in 1975?",
            R.drawable.q6,
            "India",
            "Australia",
            "England",
            "West Indies",
            4
        )
        questions.add(ques6)

        val ques7 = Question(
            7,
            "How many runs are awarded for hitting the ball over the boundary without bouncing?",
            R.drawable.q7,
            "4",
            "5",
            "6",
            "2",
            3
        )
        questions.add(ques7)

        val ques8 = Question(
            8,
            "What does LBW stand for in cricket?",
            R.drawable.q8,
            "Leg Before Wicket",
            "Long Ball Wide",
            "Leg By Wide",
            "Line Beyond Wicket",
            1
        )
        questions.add(ques8)

        val ques9 = Question(
            9,
            "What color clothing is worn in Test cricket?",
            R.drawable.q9,
            "Blue",
            "White",
            "Black",
            "Green",
            2
        )
        questions.add(ques9)

        val ques10 = Question(
            10,
            "How many umpires are there on the field during a standard cricket match?",
            R.drawable.q10,
            "1",
            "2",
            "3",
            "4",
            2
        )
        questions.add(ques10)

        return questions
    }
}
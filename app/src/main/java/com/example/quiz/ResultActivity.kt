package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.utils.Constants
class ResultActivity : AppCompatActivity() {
    private lateinit var textViewResult : TextView
    private lateinit var textViewUsername : TextView
    private lateinit var finishButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewResult = findViewById(R.id.text_username)
        textViewUsername = findViewById(R.id.text_score)
        finishButton = findViewById(R.id.button_finish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val username = intent.getStringExtra(Constants.USER_NAME)


        if(correctAnswers in 1..3){
            textViewUsername.text = "Nice Try! " + username
        }
        else if(correctAnswers in 4..6){
            textViewUsername.text = "Amazing! " + username
        }
        else if(correctAnswers in 7..8){
            textViewUsername.text = "Excellent! " + username
        }
        else{
            textViewUsername.text = "Outstanding! " + username
        }
        textViewResult.text = "Your score is $correctAnswers out of $totalQuestions"

        finishButton.setOnClickListener {
            Intent(this@ResultActivity, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}
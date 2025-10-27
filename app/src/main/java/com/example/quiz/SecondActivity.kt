package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quiz.utils.Constants
import kotlin.math.min

class SecondActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var imageViewQuestion: ImageView
    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView
    private var questionsCounter = 1
    private lateinit var questionsList: MutableList<Question>
    private lateinit var checkButton : Button
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false
    private lateinit var username : String
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        progressBar = findViewById(R.id.progressBar)
        textViewProgress = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        imageViewQuestion = findViewById(R.id.image_question)
        textViewOptionOne = findViewById(R.id.text_view_option1)
        textViewOptionTwo = findViewById(R.id.text_view_option2)
        textViewOptionThree = findViewById(R.id.text_view_option3)
        textViewOptionFour = findViewById(R.id.text_view_option4)
        checkButton = findViewById(R.id.check_btn)

        username = intent.getStringExtra(Constants.USER_NAME) ?: "User"

        questionsList = Constants.getQuestions()
        showNextQuestion()


        textViewOptionOne.setOnClickListener (this)
        textViewOptionTwo.setOnClickListener (this)
        textViewOptionThree.setOnClickListener (this)
        textViewOptionFour.setOnClickListener (this)
        checkButton.setOnClickListener(this)
    }
    private fun showNextQuestion() {
        // Always reset the previous options before showing a new question
        resetQuestion()

        // Check if we’ve reached the end
        if (questionsCounter > questionsList.size) {
            // Navigate to ResultActivity
            val intent = Intent(this@SecondActivity, ResultActivity::class.java)
            intent.putExtra(Constants.USER_NAME,username)
            intent.putExtra(Constants.TOTAL_QUESTIONS,questionsList.size)
            intent.putExtra(Constants.CORRECT_ANSWERS, min(10,score))
            startActivity(intent)
            finish()

            return
        }

        // Load the current question
        currentQuestion = questionsList[questionsCounter - 1]
        imageViewQuestion.setImageResource(currentQuestion.image)
        progressBar.progress = questionsCounter
        textViewProgress.text = "$questionsCounter/${progressBar.max}"
        textViewQuestion.text = currentQuestion.question
        textViewOptionOne.text = currentQuestion.option1
        textViewOptionTwo.text = currentQuestion.option2
        textViewOptionThree.text = currentQuestion.option3
        textViewOptionFour.text = currentQuestion.option4

        checkButton.text = getString(R.string.check)
        answered = false
        selectedAnswer = 0
    }
    private fun resetQuestion(){
        val optionList = mutableListOf<TextView>()
        optionList.add(textViewOptionOne)
        optionList.add(textViewOptionTwo)
        optionList.add(textViewOptionThree)
        optionList.add(textViewOptionFour)

        for (option in optionList) {
           option.setTextColor(Color.parseColor("#7A8089"))
           option.typeface = Typeface.DEFAULT
           option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOption(textView : TextView , selectedOptionNumber : Int){
        resetQuestion()
        answered = false
        checkButton.text = getString(R.string.check)
        selectedAnswer = selectedOptionNumber
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.selected_rounded_image_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.text_view_option1 -> {
                selectedOption(textViewOptionOne,1)
            }
            R.id.text_view_option2 -> {
                selectedOption(textViewOptionTwo,2)
            }
            R.id.text_view_option3 -> {
                selectedOption(textViewOptionThree,3)
            }
            R.id.text_view_option4 -> {
                selectedOption(textViewOptionFour,4)
            }
            R.id.check_btn -> {
                if (!answered) {
                    checkAnswer()
                    showCorrectAnswer()
                } else {
                    questionsCounter++
                    showNextQuestion()
                }
            }
        }
    }

    private fun checkAnswer(){
        answered = true
        if(selectedAnswer == currentQuestion.correctAnswer){
            score++
            highlightFunction(selectedAnswer)
        }
        else{
            when(selectedAnswer){
                1 ->{
                    textViewOptionOne.background =
                        ContextCompat.getDrawable(this,R.drawable.wrong_rounded_image_bg)
                }
                2 -> {
                    textViewOptionTwo.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_rounded_image_bg)
                }
                3 -> {
                    textViewOptionThree.background =
                        ContextCompat.getDrawable(this,R.drawable.wrong_rounded_image_bg)
                }
                4 -> {
                    textViewOptionFour.background =
                        ContextCompat.getDrawable(this,R.drawable.wrong_rounded_image_bg)
                }
            }
        }
        checkButton.text = getString(R.string.moveOn)
    }

    private fun showCorrectAnswer(){
        highlightFunction(currentQuestion.correctAnswer)
    }
    private fun highlightFunction(selectedNumber : Int){
        when(selectedNumber){
            1 -> {
                textViewOptionOne.background =
                    ContextCompat.getDrawable(this,R.drawable.correct_rounded_image_bg)
            }
            2 -> {
                textViewOptionTwo.background =
                    ContextCompat.getDrawable(this,R.drawable.correct_rounded_image_bg)
            }
            3 -> {
                textViewOptionThree.background =
                    ContextCompat.getDrawable(this,R.drawable.correct_rounded_image_bg)
            }
            4 -> {
                textViewOptionFour.background =
                    ContextCompat.getDrawable(this,R.drawable.correct_rounded_image_bg)
            }
        }
    }
}
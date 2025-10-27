package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val startButton : Button = findViewById(R.id.startBtn)
        val editTextName : EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if(!editTextName.text.isEmpty()){
                val name = editTextName.text.toString()
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra(Constants.USER_NAME, name)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"You have not entered your name", Toast.LENGTH_SHORT).show()
                editTextName.setError("Please enter your name")
            }
        }
    }
}
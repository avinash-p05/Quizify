package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView = findViewById(R.id.tv_name)
        val score  : TextView = findViewById(R.id.tv_score)
        val finish : Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(constants.USER_NAME)
        val totalQ = intent.getIntExtra(constants.TOTAL_QUESTIONS,0)
        val correctQ = intent.getIntExtra(constants.CORRECT_ANSWERS,0)

        score.text =  "Your score is $correctQ/$totalQ"

        finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}
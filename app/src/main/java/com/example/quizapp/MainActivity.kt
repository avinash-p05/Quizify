package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start : Button = findViewById(R.id.start)
        val name : EditText = findViewById(R.id.name)


        start.setOnClickListener{
            if (name.text.isEmpty()){
                Toast.makeText(this,"Please enter you Name!!",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this,QuizQuestions::class.java)
                intent.putExtra(constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
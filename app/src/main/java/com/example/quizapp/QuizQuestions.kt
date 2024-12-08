package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.Result

class QuizQuestions : AppCompatActivity(), View.OnClickListener{

    private var progressBar : ProgressBar?=null
    private var progressTv : TextView?=null
    private var questionTv : TextView?=null
    private var imageV : ImageView?=null

    private var opt1Tv : TextView?=null
    private var opt2Tv : TextView?=null
    private var opt3Tv : TextView?=null
    private var opt4Tv : TextView?=null
    private var submit : Button?=null

    private var currentPos : Int = 1
    private var QuestionList: ArrayList<Question>?=null
    private var selectedOpt : Int = 0
    private var username : String?=null
    private var correctans : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        progressBar = findViewById(R.id.progessBar)
        progressTv = findViewById(R.id.progess)
        questionTv = findViewById(R.id.question)
        imageV = findViewById(R.id.image)
        submit = findViewById(R.id.submit)
        opt1Tv = findViewById(R.id.option1)
        opt2Tv = findViewById(R.id.option2)
        opt3Tv = findViewById(R.id.option3)
        opt4Tv = findViewById(R.id.option4)

        username = intent.getStringExtra(constants.USER_NAME)


        QuestionList = constants.getQuestions()

        opt1Tv?.setOnClickListener(this)
        opt2Tv?.setOnClickListener(this)
        opt3Tv?.setOnClickListener(this)
        opt4Tv?.setOnClickListener(this)

        submit?.setOnClickListener(this)

        setQuestion()

    }

    private fun setQuestion() {

        defaultOptionsView()
        //accessing each question
        val question: Question = QuestionList!![currentPos - 1]


        //setting everything
        imageV?.setImageResource(question.image)
        progressBar?.progress = currentPos
        progressTv?.text = "$currentPos/${progressBar?.max}"
        questionTv?.text = question.question
        opt1Tv?.text = question.option1
        opt2Tv?.text = question.option2
        opt3Tv?.text = question.option3
        opt4Tv?.text = question.option4


        if(currentPos  == QuestionList!!.size + 1){
            submit?.text="FINISH"
        }
        else{
            submit?.text="SUBMIT"
        }


    }

    @SuppressLint("ResourceAsColor")
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        opt1Tv?.let {
            options.add(0,it)
        }
        opt2Tv?.let {
            options.add(1,it)
        }
        opt3Tv?.let {
            options.add(2,it)
        }
        opt4Tv?.let {
            options.add(3,it)
        }

        for(option in options){
            option.background = ContextCompat.getDrawable(this,R.drawable.option_border_bg)
            option.setTextColor(R.color.option)
            option.typeface = Typeface.DEFAULT

        }
    }

    //selected option
    private fun selectedOptionView(tv:TextView , selectedOptNum : Int){

        defaultOptionsView()

        selectedOpt = selectedOptNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface , Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_opt_border_bg)

    }




    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1 -> {
                opt1Tv?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.option2 -> {
                opt2Tv?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.option3 -> {
                opt3Tv?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.option4 -> {
                opt4Tv?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.submit ->{
                if(selectedOpt == 0){
                    currentPos++

                   when{
                       currentPos<=QuestionList!!.size ->{
                           setQuestion()
                       }
                       else->{
                           val intent = Intent(this,Result::class.java)
                           intent.putExtra(constants.USER_NAME,username)
                           intent.putExtra(constants.CORRECT_ANSWERS,correctans)
                           intent.putExtra(constants.TOTAL_QUESTIONS,QuestionList?.size)
                           startActivity(intent)
                           finish()
                       }
                   }
                }
                else{
                    val question = QuestionList!!.get(currentPos - 1)
                    if(question!!.correctAns != selectedOpt)
                        answerView(selectedOpt,R.drawable.wrong_option_border_bg)
                    else
                        correctans++
                    answerView(question.correctAns,R.drawable.correct_option_border_bg)

                    if(currentPos  == QuestionList!!.size ){
                        submit?.text = "FINISH"
                    }
                    else{
                        submit?.text = "NEXT"
                    }
                    selectedOpt = 0

                }
            }
        }

    }

    private fun answerView (ans : Int , drawableView : Int){
        when(ans){
            1->{
                opt1Tv?.background = ContextCompat.getDrawable(this,drawableView)
                opt1Tv?.setTextColor(Color.parseColor("#363a43"))
                opt1Tv?.setTypeface(opt1Tv?.typeface , Typeface.BOLD)
            }
            2->{
                opt2Tv?.background = ContextCompat.getDrawable(this,drawableView)
                opt2Tv?.setTextColor(Color.parseColor("#363a43"))
                opt2Tv?.setTypeface(opt2Tv?.typeface , Typeface.BOLD)
            }
            3->{
                opt3Tv?.background = ContextCompat.getDrawable(this,drawableView)
                opt3Tv?.setTextColor(Color.parseColor("#363a43"))
                opt3Tv?.setTypeface(opt3Tv?.typeface , Typeface.BOLD)
            }
            4->{
                opt4Tv?.background = ContextCompat.getDrawable(this,drawableView)
                opt4Tv?.setTextColor(Color.parseColor("#363a43"))
                opt4Tv?.setTypeface(opt4Tv?.typeface , Typeface.BOLD)
            }
        }
    }
}
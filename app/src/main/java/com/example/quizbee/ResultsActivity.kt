package com.example.quizbee

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsActivity : Activity() {
    private lateinit var restartbutton:Button
    private lateinit var correct:TextView
    private lateinit var wrong:TextView
    private lateinit var final:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        correct = findViewById(R.id.TvCorrectRes)
        wrong = findViewById(R.id.TvWrongRes)
        final = findViewById(R.id.TvFinalRes)
        restartbutton = findViewById(R.id.BtnRestart)

        val correctsubmit = StringBuffer()
        correctsubmit.append(
            """ Correct answers: ${QuestionActivity.correct}""".trimIndent()
        )

        val wrongsubmit = StringBuffer()
        wrongsubmit.append(
            """Wrong answer : ${QuestionActivity.wrong}""".trimIndent()
        )

        val finalsubmit = StringBuffer()
        finalsubmit.append(
            """Final Score: ${QuestionActivity.correct}""".trimIndent()
        )

        correct.text = correctsubmit
        wrong.text = wrongsubmit
        final.text = finalsubmit
        QuestionActivity.correct = 0
        QuestionActivity.wrong = 0
        restartbutton.setOnClickListener {
            val restart = Intent(applicationContext, MainActivity::class.java)
            startActivity(restart)
        }
    }
}
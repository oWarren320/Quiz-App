package com.example.quizbee

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.quizbee.MainActivity
import com.example.quizbee.R


class DeveloperActivity : Activity() {
    private lateinit var btnRestart: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)
        btnRestart = findViewById<View>(R.id.BtnRestart) as Button
        btnRestart.setOnClickListener {
            val in2 = Intent(applicationContext, MainActivity::class.java)
            startActivity(in2)
        }
    }
}
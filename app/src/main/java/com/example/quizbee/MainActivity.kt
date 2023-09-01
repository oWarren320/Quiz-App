package com.example.quizbee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var startbutton:Button
    private lateinit var aboutbutton:Button
    private lateinit var nametext:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startbutton = findViewById(R.id.Btnstart)
        aboutbutton = findViewById(R.id.Btnabout)
        nametext = findViewById(R.id.EdtName)

        startbutton.setOnClickListener {
            val name = nametext.text.toString()
            val intent = Intent(applicationContext, QuestionActivity::class.java)
            intent.putExtra("my name", name)
            startActivity(intent)
        }

        aboutbutton.setOnClickListener {
            val about = Intent(applicationContext, DeveloperActivity::class.java)
            startActivity(about)
        }

    }
}
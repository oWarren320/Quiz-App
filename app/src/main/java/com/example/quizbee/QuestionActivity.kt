package com.example.quizbee

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class QuestionActivity : Activity() {
    // Declare the UI elements as lateinit variables
    private lateinit var question:TextView
    private lateinit var submitbutton:Button
    private lateinit var quitbutton: Button
    private lateinit var radio: RadioGroup
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var rb4: RadioButton

    // Arrays to store quiz questions, answers, and options
    var questions = arrayOf(
        "Which method can be defined only once in a program?",
        "Which of these is not a bitwise operator?",
        "Which keyword is used by method to refer to the object that invoked it?",
        "Which of these keywords is used to define interfaces in Java?",
        "Which of these access specifiers can be used for an interface?",
        "Which of the following is correct way of importing an entire package ‘pkg’?",
        "What is the return type of Constructors?",
        "Which of the following package stores all the standard java classes?",
        "Which of these method of class String is used to compare two String objects for their equality?",
        "An expression involving byte, int, & literal numbers is promoted to which of these?"
    )

    var answers = arrayOf(
        "main method",
        "<=",
        "this",
        "interface",
        "public",
        "import pkg.*",
        "None of the mentioned",
        "java",
        "equals()",
        "int"
    )

    var opt = arrayOf(
        "WOW method", "main method", "static method", "private method",
        "&", "&=", "|=", "<=",
        "import", "this", "catch", "abstract",
        "Interface", "interface", "intf", "Intf",
        "public", "protected", "private", "All of the mentioned",
        "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
        "int", "float", "void", "None of the mentioned",
        "lang", "java", "util", "java.packages",
        "equals()", "Equals()", "isequal()", "Isequal()",
        "int", "long", "byte", "float"
    )

    // Flag to keep track of the current question
    var flag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        // Initialize UI elements
        val numscore = findViewById<TextView>(R.id.TVNumScore)
        val displayname = findViewById<TextView>(R.id.DisplayName)

        // Get the name from the previous activity
        val intent = intent
        val name = intent.getStringExtra("my name")

        // Set a greeting message based on the name
        if (name!!.trim {it <= ' '} == " ") {
            displayname.text = "Hello User"

        }else {
            displayname.text = " Hello $name"
        }

        // Initialize UI elements
        submitbutton = findViewById(R.id.BtnSubmit)
        quitbutton = findViewById(R.id.BtnQuit)
        question = findViewById(R.id.TVquestion)
        radio = findViewById(R.id.answergrp)
        rb1 = findViewById(R.id.RB1)
        rb2 = findViewById(R.id.RB2)
        rb3 = findViewById(R.id.RB3)
        rb4 = findViewById(R.id.RB4)

        // Set the initial question and answer options
        question!!.text = questions[flag]
        rb1!!.text=opt[0]
        rb2!!.text=opt[1]
        rb3!!.text=opt[2]
        rb4!!.text=opt[3]

        //activity on submit btn
        submitbutton!!.setOnClickListener (View.OnClickListener setOnClickListener@{
            if (radio!!.checkedRadioButtonId ==-1) {
                // Set the initial question and answer options
                Toast.makeText(applicationContext, "Please seect one choice", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val uanswer = findViewById<RadioButton>(radio!!.checkedRadioButtonId)
            val ansText = uanswer.text.toString()
            if (ansText == answers[flag]) {
                correct++
                Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
            }else {
                wrong++
                Toast.makeText(applicationContext, "Wrong", Toast.LENGTH_SHORT).show()
            }
            flag++
            // Calculate score
            if (numscore != null ) numscore.text = "" + correct

            if (flag < questions.size) {
                question!!.text = questions[flag]
                rb1!!.text = opt[flag * 4]
                rb2!!.text = opt[flag * 4 + 1]
                rb3!!.text = opt[flag * 4 + 2]
                rb4!!.text = opt[flag * 4 + 3]
            }else {
                marks = correct
                val results = Intent(applicationContext, ResultsActivity::class.java)
                startActivity(results)
            }

            radio!!.clearCheck()
        })

        // Set an onClickListener for the quit button
        quitbutton!!.setOnClickListener {
            val quit = Intent(applicationContext, ResultsActivity::class.java)
            startActivity(quit)
        }

    }
    companion object {
        var marks = 0
        @JvmField
        var correct = 0
        @JvmField
        var wrong = 0
    }
}
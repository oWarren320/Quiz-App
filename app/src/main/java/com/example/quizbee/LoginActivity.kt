package com.example.quizbee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity()  {
    lateinit var tvRedirectSignup: TextView
    lateinit var EtEmail:EditText
    lateinit var EtPass: EditText
    lateinit var btnLogin: Button

    // creating firebaseAuth object
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //View Binding
        tvRedirectSignup = findViewById(R.id.tvlackacc)
        btnLogin = findViewById(R.id.btnlogin)
        EtEmail = findViewById(R.id.Etemailaddress)
        EtPass = findViewById(R.id.Etpassword)

        // initialising firebase auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }

        tvRedirectSignup.setOnClickListener {
            val active = Intent(this, MainActivity::class.java)
            startActivity(active)
            finish()
        }
    }

    private fun login() {
        val email = EtEmail.text.toString()
        val pass = EtPass.text.toString()

        // calling

        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                // Toast.makeText(this, "Successfully logged in. ", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Log in failed. ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.example.quizbee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {
    private lateinit var EdtEmail: EditText
    private lateinit var EdtPass: EditText
    private lateinit var EdtConf: EditText
    private lateinit var BtnSignup: Button
    private lateinit var TvDirectLogin: TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        EdtEmail=findViewById(R.id.ETSemailaddress)
        EdtPass=findViewById(R.id.ETSPassword)
        EdtConf=findViewById(R.id.ETSConfPassword)
        BtnSignup=findViewById(R.id.btnSSigned)
        TvDirectLogin=findViewById(R.id.tvRedirectSignup)
        auth= Firebase.auth

        BtnSignup.setOnClickListener {
            SignUpUser()
        }
        TvDirectLogin.setOnClickListener {
            val active = Intent(this, LoginActivity::class.java)
            startActivity(active)
        }

    }

    private fun SignUpUser(){
        val email=EdtEmail.text.toString()
        val pass=EdtPass.text.toString()
        val confpass=EdtConf.text.toString()
        if (email.isBlank() || pass.isBlank() || confpass.isBlank()){
            Toast.makeText(this, "Email and password cannot be blank", Toast.LENGTH_LONG).show()
            return
        } else if (pass != confpass){
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
            return
        }

        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener (this){
            if (it.isSuccessful){
                Toast.makeText(this, "Signed successfully", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this, "Failed to create", Toast.LENGTH_LONG).show()
            }

        }

    }
}
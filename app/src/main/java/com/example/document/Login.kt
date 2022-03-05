package com.example.document

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Matcher
import java.util.regex.Pattern

class Login : AppCompatActivity() {

    lateinit var textEmailId: TextInputEditText
    lateinit var textPassword: TextInputEditText
    lateinit var buttonLogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        textEmailId = findViewById(R.id.emailId)
        textPassword = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.loginButton)

        buttonLogin.setOnClickListener {
            LoginFunc()
        }


    }

    private fun LoginFunc() {
        val strEmail = textEmailId.text.toString().trim()
        val strPassword = textPassword.text.toString().trim()

        if (TextUtils.isEmpty(strEmail) || TextUtils.isEmpty(strPassword))
        {
            textEmailId.error = "Can't be empty"
            textPassword.error= "Can't be empty"
        }else if(!EmailValidationFunc(strEmail))
        {
            textEmailId.error = "Not Valid Email Address..."
        }else{
            Toast.makeText(applicationContext,"Login Successful...", Toast.LENGTH_LONG).show()
            isSuccefully()
        }
    }

    private fun EmailValidationFunc(strEmail: String): Boolean {
        val EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher: Matcher = pattern.matcher(strEmail)
        return matcher.matches()
    }

    private fun isSuccefully() {
        startActivity(Intent(this@Login, DemoMain::class.java))
        finish()
    }
}
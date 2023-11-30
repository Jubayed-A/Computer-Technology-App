package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.log

class SignUpTeacher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_teacher)

        val logIn = findViewById<TextView>(R.id.haveAnAccountTeacher)

        logIn.setOnClickListener {
            val intentLogIn = Intent(this, LogInActivity::class.java)
            startActivity(intentLogIn)
        }

    }
}
package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val signUpStudent = findViewById<TextView>(R.id.dontHaveAccountStudent)
        val signUpTeacher = findViewById<TextView>(R.id.dontHaveAccountTeacher)

        signUpStudent.setOnClickListener {
            val intentSigUp = Intent(this, Student_Add::class.java)
            startActivity(intentSigUp)
        }
        signUpTeacher.setOnClickListener {
            val intentSignUpTeacher = Intent(this, SignUpTeacher::class.java)
            startActivity(intentSignUpTeacher)
        }

    }
}
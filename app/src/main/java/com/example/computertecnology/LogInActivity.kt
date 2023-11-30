package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val sigUpStudent = findViewById<TextView>(R.id.dontHaveAccountStudent)
        val sigUpTeacher = findViewById<TextView>(R.id.dontHaveAccountTeacher)

        sigUpStudent.setOnClickListener {
            val intentSigUp = Intent(this, SigUpActivity::class.java)
            startActivity(intentSigUp)
        }
        sigUpTeacher.setOnClickListener {
            val intentSignUpTeacher = Intent(this, SignUpTeacher::class.java)
            startActivity(intentSignUpTeacher)
        }

    }
}
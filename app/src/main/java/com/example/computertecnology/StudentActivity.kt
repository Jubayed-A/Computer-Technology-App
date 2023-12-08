package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val studentAdd = findViewById<LinearLayout>(R.id.addStudent)
        val studentInfo = findViewById<LinearLayout>(R.id.studentInfo)

        studentAdd.setOnClickListener {
            val intentAdd = Intent(this, Student_Add::class.java)
            startActivity(intentAdd)
        }

        studentInfo.setOnClickListener {
            val intentInfo = Intent(this, StudentInformation::class.java)
            startActivity(intentInfo)
        }

    }
}
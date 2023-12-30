package com.example.computertecnology.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.computertecnology.R

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

       // variable declaration 
        val studentAdd = findViewById<LinearLayout>(R.id.addStudent)
        val studentInfo = findViewById<LinearLayout>(R.id.studentInfo)
        val studentUpdate = findViewById<LinearLayout>(R.id.updateStudent)
        val studentRemove = findViewById<LinearLayout>(R.id.removeStudent)

        // student add
        studentAdd.setOnClickListener {
            val intentAdd = Intent(this, Student_Add::class.java)
            startActivity(intentAdd)
        }

        //         student info
        studentInfo.setOnClickListener {
            val intentInfo = Intent(this, StudentInformation::class.java)
            startActivity(intentInfo)
        }

        //        student update
        studentUpdate.setOnClickListener {
            val intentUpdate = Intent(this, StudentUpdate::class.java)
            startActivity(intentUpdate)
        }

        //        student remove
        studentRemove.setOnClickListener {
            val intentRemove = Intent(this, StudentRemove::class.java)
            startActivity(intentRemove)
        }

    }
}
package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class StudentRemove : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_remove)

        // student add code here
        val removingStudent = findViewById<MaterialButton>(R.id.removeStudent)
        val roll = findViewById<EditText>(R.id.stdRoll)


        // add button code here
        removingStudent.setOnClickListener {

            val sRoll = roll.text.toString().trim()


            if (sRoll.isNotEmpty()) {
                // All fields are filled, perform your action here
                Toast.makeText(this, "This feature will be developed.", Toast.LENGTH_SHORT).show()

            } else {
                // Not all fields are filled
                Toast.makeText(this, "Please enter BoardRoll.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
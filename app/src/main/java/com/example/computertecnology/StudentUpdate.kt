package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast

class StudentUpdate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_update)

        // semester text code here
        val semester = arrayOf(
            "1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
            "5th Semester", "6th Semester", "7th Semester", "8th Semester" )

        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, semester)
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.itemSemester)
        autoCompleteTextView.setAdapter(arrayAdapter)

        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, autoCompleteTextView.text, Toast.LENGTH_SHORT).show()
        }


    }
}
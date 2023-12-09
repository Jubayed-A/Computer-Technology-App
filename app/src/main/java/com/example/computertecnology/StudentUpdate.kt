package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class StudentUpdate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_update)

        // semester text code here
        val semester = arrayOf(
            "1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
            "5th Semester", "6th Semester", "7th Semester", "8th Semester" )

        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, semester)
        val selectSemester = findViewById<AutoCompleteTextView>(R.id.itemSemester)
        selectSemester.setAdapter(arrayAdapter)

        selectSemester.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, selectSemester.text, Toast.LENGTH_SHORT).show()
        }


        // student add code here
        val addingStudent = findViewById<MaterialButton>(R.id.studentUpdate)
        val name = findViewById<EditText>(R.id.stdName)
        val roll = findViewById<EditText>(R.id.stdRoll)
        val section = findViewById<EditText>(R.id.stdSection)
        val department = findViewById<EditText>(R.id.stdDepartment)
        val phone = findViewById<EditText>(R.id.stdPhone)

        // add button code here
        addingStudent.setOnClickListener {
            val sName = name.text.toString().trim()
            val sRoll = roll.text.toString().trim()
            val sSection = section.text.toString().trim()
            val sDepartment = department.text.toString().trim()
            val sPhone = phone.text.toString().trim()
            val sSemester = selectSemester.text.toString().trim()
            val defaultSemesterText  = "Choose Semester"


            if (sName.isNotEmpty() && sRoll.isNotEmpty() && sSection.isNotEmpty() && sDepartment.isNotEmpty()
                && sPhone.isNotEmpty()) {
                // All fields are filled, perform your action here
                if (sSemester != defaultSemesterText){
                    Toast.makeText(this, "This feature will be developed.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Please select a semester.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Not all fields are filled
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
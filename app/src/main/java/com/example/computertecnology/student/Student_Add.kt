package com.example.computertecnology.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import com.example.computertecnology.R
import com.example.computertecnology.Users
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Student_Add : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_add)

        // semester text code here
        val semester = arrayOf(
            "1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
            "5th Semester", "6th Semester", "7th Semester", "8th Semester"
        )

        val arrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, semester)
        val semesterList = findViewById<AutoCompleteTextView>(R.id.autoItem)
        semesterList.setAdapter(arrayAdapter)

        semesterList.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, semesterList.text, Toast.LENGTH_SHORT).show()
        }

        // student add code here
        val addingStudent = findViewById<MaterialButton>(R.id.studentAdd)
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
            val sSemester = semesterList.text.toString().trim()
            val defaultSemesterText = "Choose Semester"


            // check user exit or not

            if (sName.isNotEmpty() && sRoll.isNotEmpty() && sSection.isNotEmpty() && sDepartment.isNotEmpty()
                && sPhone.isNotEmpty()) {
                // All fields are filled, perform your action here
                if (sSemester != defaultSemesterText) {


                    database = FirebaseDatabase.getInstance().getReference("Users")
                    database.child(sRoll)
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    // user with same roll number already exits
                                    Toast.makeText(
                                        this@Student_Add,
                                        "User already registered with same Board Roll.",
                                        Toast.LENGTH_LONG
                                    ).show()
                                } else {
                                    val user = Users(
                                        sName,
                                        sRoll,
                                        sSection,
                                        sDepartment,
                                        sSemester,
                                        sPhone
                                    )
                                    database.child(sRoll).setValue(user).addOnSuccessListener {
                                        name.text.clear()
                                        roll.text.clear()
                                        section.text.clear()
                                        department.text.clear()
                                        semesterList.setText(defaultSemesterText)
                                        phone.text.clear()
                                        name.requestFocus()
                                        Toast.makeText(
                                            this@Student_Add,
                                            "User Registered",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }.addOnFailureListener {
                                        Toast.makeText(
                                            this@Student_Add,
                                            "User Registered Failed",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Toast.makeText(
                                    this@Student_Add,
                                    "Database Error.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
//                    Toast.makeText(this, "This feature will be developed.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please select a semester.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Not all fields are filled
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
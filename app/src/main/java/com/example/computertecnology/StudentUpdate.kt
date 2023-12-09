package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StudentUpdate : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_update)

        // semester text code here
        val semester = arrayOf(
            "1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
            "5th Semester", "6th Semester", "7th Semester", "8th Semester"
        )

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
            val defaultSemesterText = "Choose Semester"

            // update user on database
            if (sName.isNotEmpty() && sRoll.isNotEmpty() && sSection.isNotEmpty() && sDepartment.isNotEmpty()
                && sPhone.isNotEmpty()
            ) {
                // All fields are filled, perform your action here
                if (sSemester != defaultSemesterText) {
                    databaseReference = FirebaseDatabase.getInstance().getReference("Users")
                    databaseReference.child(sRoll)
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    // user exit with same roll number
                                    val user = Users(
                                        sName,
                                        sRoll,
                                        sSection,
                                        sDepartment,
                                        sSemester,
                                        sPhone
                                    )
                                    databaseReference.child(sRoll).setValue(user)
                                        .addOnSuccessListener {
                                            name.text.clear()
                                            roll.text.clear()
                                            section.text.clear()
                                            department.text.clear()
                                            selectSemester.setText(defaultSemesterText)
                                            phone.text.clear()
                                            name.requestFocus()
                                            Toast.makeText(
                                                this@StudentUpdate,
                                                "User Update Successfully",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }.addOnFailureListener {
                                            Toast.makeText(
                                                this@StudentUpdate,
                                                "User Update Failed",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                } else {
                                    // user doesn't exist
                                    Toast.makeText(
                                        this@StudentUpdate,
                                        "User Not Registered",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }

                            // error handling
                            override fun onCancelled(error: DatabaseError) {
                                Toast.makeText(
                                    this@StudentUpdate,
                                    "Database Error",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                    // semester not selected
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
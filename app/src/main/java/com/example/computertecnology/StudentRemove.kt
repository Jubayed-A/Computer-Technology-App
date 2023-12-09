package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StudentRemove : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference

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
                databaseReference = FirebaseDatabase.getInstance().getReference("Users")
                databaseReference.child(sRoll)
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                // user with the roll number exit and now remove user
                                databaseReference.child(sRoll).removeValue().addOnSuccessListener {
                                    roll.text.clear()
                                    Toast.makeText(
                                        this@StudentRemove,
                                        "User Removed Successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }.addOnFailureListener {
                                    Toast.makeText(
                                        this@StudentRemove,
                                        "User Remove Failed",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                // user doesn't exit with the roll number
                                Toast.makeText(
                                    this@StudentRemove,
                                    "User Not Found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        // error handling
                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(this@StudentRemove, "Database Error", Toast.LENGTH_SHORT)
                                .show()
                        }

                    })

            } else {
                // Not all fields are filled
                Toast.makeText(this, "Please enter BoardRoll.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
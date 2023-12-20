package com.example.computertecnology.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StudentInformation : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentArrayList: ArrayList<StdData>
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_information)

        recyclerView = findViewById(R.id.studentRecyclerView)
        studentArrayList = ArrayList()


        // data from database

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        // get data form firebase
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                studentArrayList.clear()
                for (dataSnapshot in snapshot.children) {
                    val name = dataSnapshot.child("name").getValue(String::class.java) ?: ""
                    val roll = dataSnapshot.child("roll").getValue(String::class.java) ?: ""
                    val section = dataSnapshot.child("section").getValue(String::class.java) ?: ""
                    val department =
                        dataSnapshot.child("department").getValue(String::class.java) ?: ""
                    val semester = dataSnapshot.child("semester").getValue(String::class.java) ?: ""
                    val phone = dataSnapshot.child("phone").getValue(String::class.java) ?: ""

                    val users = StdData(name, roll, section, department, semester, phone)
                    studentArrayList.add(users)
                }


                // set adapter after get data from database
                val studentAdapter = StudentAdapter(studentArrayList, this@StudentInformation)
                recyclerView.adapter = studentAdapter

                // set layout-manager to call data for // to set behave of item inside recyclerview
                recyclerView.layoutManager = LinearLayoutManager(this@StudentInformation)

            }

            // error handling
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@StudentInformation, "Database Error", Toast.LENGTH_SHORT).show()
            }

        })

    }
}
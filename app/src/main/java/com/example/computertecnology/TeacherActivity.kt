package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeacherActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teacherArrayList: ArrayList<Teacher>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        recyclerView = findViewById(R.id.teacherRecyclerView)

        // teacher image declare
        val teacherImageArray = arrayOf(
            R.drawable.sample_img,
            R.drawable.img2
        )

        // teacher name declare
        val teacherNameArray = arrayOf(
            "Sahinur Islam Sahin",
            "Polash Chandro Bisswas"
        )

        // teacher prof declare
        val teacherProfArray = arrayOf(
            "Chief Instructor(CI)",
            "Senior Instructor"
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized teacher array list
        teacherArrayList = arrayListOf<Teacher>()

        // add all data one by one to teacherArrayList
        for (index in teacherImageArray.indices){
            val teacher = Teacher(teacherNameArray[index], teacherImageArray[index], teacherProfArray[index])
            teacherArrayList.add(teacher)
        }

        // adapter code here
        val teacherAdapter = TeacherAdapter(teacherArrayList, this)
        recyclerView.adapter = teacherAdapter

        // click on each teacher


    }
}
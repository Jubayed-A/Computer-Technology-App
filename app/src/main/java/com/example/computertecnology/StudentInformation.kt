package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.TeacherAdapter.onItemClickListener

class StudentInformation : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentArrayList: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_information)

        recyclerView = findViewById(R.id.studentRecyclerView)

        // student image declare
        val studentImgArray = arrayOf(
            R.drawable.sample_img,
            R.drawable.img2
        )

        // student name declare
        val studentNameArray = arrayOf(
            "Sahinur Islam Sahin",
            "Polash Chandro Bisswas"
        )

        // student prof declare
        val studentProfArray = arrayOf(
            "Chief Instructor(CI)",
            "Senior Instructor"
        )

        // student description
        val studentDescriptionArray = arrayOf(
            "Shahinur islam shain is Chief instructor of computer department ",
            "Plolas Chondro Biswas is a Senior Instructor of computer department"
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized teacher array list
        studentArrayList = arrayListOf<Data>()

        // add all data one by one to teacherArrayList
        for (index in studentImgArray.indices){
            val teacher = Data(studentNameArray[index], studentImgArray[index], studentProfArray[index], studentDescriptionArray[index])
            studentArrayList.add(teacher)
        }

        // adapter code here
        val studentAdapter = StudentAdapter(studentArrayList, this)
        recyclerView.adapter = studentAdapter

        // click on each teacher
        studentAdapter.setOnItemClickListener(object : StudentAdapter.onItemClickListener{
            override fun onItemClicking(position: Int) {
                // on clicking each teacher what action do you want to perform
                val intentStudentProfile = Intent(this@StudentInformation, StudentProfile::class.java)
                intentStudentProfile.putExtra("name", studentArrayList[position].name)
                intentStudentProfile.putExtra("description", studentArrayList[position].description)
                intentStudentProfile.putExtra("image", studentArrayList[position].image)
                startActivity(intentStudentProfile)
            }

        })

    }
}
package com.example.computertecnology.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.Data
import com.example.computertecnology.R
import com.example.computertecnology.teacher.TeacherAdapter.onItemClickListener

class TeacherActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teacherArrayList: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        recyclerView = findViewById(R.id.teacherRecyclerView)

        // teacher image declare
        val teacherImageArray = arrayOf(
            R.drawable.shahinur,
            R.drawable.massud,
            R.drawable.palash,
            R.drawable.mam
        )

        // teacher name declare
        val teacherNameArray = arrayOf(
            "Shahinur Islam Shahin",
            "Masood Raana",
            "Palash Chandra Biswas",
            "Rubaia Amina"
        )

        // teacher prof declare
        val teacherProfArray = arrayOf(
            "Chief Instructor(Computer Science & Technology)",
            "Junior Instructor(Computer Science & Technology)",
            "Instructor(Computer Science & Technology)",
            "Instructor(Computer Science & Technology)"
        )

        // teacher description
        val teacherDescriptionArray = arrayOf(
            getString(R.string.shahinur_sir_description),
            getString(R.string.masood_sir_description),
            getString(R.string.palash_sir_description),
            getString(R.string.rubia_mam_description),
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized teacher array list
        teacherArrayList = arrayListOf<Data>()

        // add all data one by one to teacherArrayList
        for (index in teacherImageArray.indices){
            val teacher = Data(teacherNameArray[index], teacherImageArray[index], teacherProfArray[index], teacherDescriptionArray[index])
            teacherArrayList.add(teacher)
        }

        // adapter code here
        val teacherAdapter = TeacherAdapter(teacherArrayList, this)
        recyclerView.adapter = teacherAdapter

        // click on each teacher
        teacherAdapter.setOnItemClickListener(object : onItemClickListener{
            override fun onItemClicking(position: Int) {
                // on clicking each teacher what action do you want to perform
                val intentTeacherProfile = Intent(this@TeacherActivity, TeacherProfile::class.java)
                intentTeacherProfile.putExtra("name", teacherArrayList[position].name)
                intentTeacherProfile.putExtra("description", teacherArrayList[position].description)
                intentTeacherProfile.putExtra("image", teacherArrayList[position].image)
                startActivity(intentTeacherProfile)
            }

        })

    }
}
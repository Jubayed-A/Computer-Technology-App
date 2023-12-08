package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.TeacherAdapter.onItemClickListener

class TeacherActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teacherArrayList: ArrayList<Data>
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

        // teacher description
        val teacherDescriptionArray = arrayOf(
            "Shahinur islam shain is Chief instructor of computer department ",
            "Plolas Chondro Biswas is a Senior Instructor of computer department"
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
package com.example.computertecnology.teacher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.computertecnology.R

class TeacherProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_profile)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val image = intent.getIntExtra("image", R.drawable.img2)

        val teacherName = findViewById<TextView>(R.id.teacherName)
        val teacherDescription = findViewById<TextView>(R.id.teacherDescription)
        val teacherImage = findViewById<ImageView>(R.id.teacherImg)

        teacherName.text = name
        teacherDescription.text = description
        teacherImage.setImageResource(image)

    }
}
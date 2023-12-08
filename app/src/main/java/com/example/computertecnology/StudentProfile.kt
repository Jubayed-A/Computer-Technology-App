package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class StudentProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_profile)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val image = intent.getIntExtra("image", R.drawable.img2)

        val studentName = findViewById<TextView>(R.id.studentName)
        val studentDescription = findViewById<TextView>(R.id.studentDescription)
        val studentImage = findViewById<ImageView>(R.id.studentImg)

        studentName.text = name
        studentDescription.text = description
        studentImage.setImageResource(image)



    }
}
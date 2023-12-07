package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val teacher = findViewById<CardView>(R.id.teacherCardView)
        val student = findViewById<CardView>(R.id.studentCardView)
        val gallery = findViewById<CardView>(R.id.galleryCardView)
        val notice = findViewById<CardView>(R.id.noticeCardView)
        val lab = findViewById<CardView>(R.id.labCardView)

        // teacher section
        teacher.setOnClickListener {
            val intentLog  = Intent(this, LogInActivity::class.java)
            startActivity(intentLog)
        }

        // student section
        student.setOnClickListener {
            val intentStudent = Intent(this, StudentActivity::class.java)
            startActivity(intentStudent)
        }

        // gallery section
        gallery.setOnClickListener {
            val intentGallery = Intent(this, GalleryActivity::class.java)
            startActivity(intentGallery)
        }
        // notice section
        notice.setOnClickListener {
            val intentNotice = Intent(this, NoticeActivity::class.java)
            startActivity(intentNotice)
        }

        // lab section
        lab.setOnClickListener {
            val intentLab = Intent(this, LabActivity::class.java)
            startActivity(intentLab)
        }



    }
}
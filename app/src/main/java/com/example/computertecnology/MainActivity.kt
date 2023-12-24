package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.computertecnology.gallery.GalleryActivity
import com.example.computertecnology.lab.LabActivity
import com.example.computertecnology.notice.NoticeActivity
import com.example.computertecnology.student.StudentActivity
import com.example.computertecnology.teacher.TeacherActivity
import com.example.computertecnology.welcome.WelcomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val teacher = findViewById<CardView>(R.id.teacherCardView)
        val student = findViewById<CardView>(R.id.studentCardView)
        val gallery = findViewById<CardView>(R.id.galleryCardView)
        val notice = findViewById<CardView>(R.id.noticeCardView)
        val lab = findViewById<CardView>(R.id.labCardView)
        val welcome = findViewById<CardView>(R.id.welcomeToUser)

        // teacher section
        teacher.setOnClickListener {
            val intentTeacher = Intent(this, TeacherActivity::class.java)
            startActivity(intentTeacher)
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

        // welcome section
        welcome.setOnClickListener {
            val intentWelcome = Intent(this, WelcomeActivity::class.java)
            startActivity(intentWelcome)
        }


    }
}
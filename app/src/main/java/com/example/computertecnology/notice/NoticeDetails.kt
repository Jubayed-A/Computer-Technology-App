package com.example.computertecnology.notice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.computertecnology.R

class NoticeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_details)

// intent gets 
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val image = intent.getIntExtra("image", R.drawable.img2)

// variable or I'd declaration 
        val noticeName = findViewById<TextView>(R.id.noticeName)
        val noticeDescription = findViewById<TextView>(R.id.noticeDescription)
        val noticeImage = findViewById<ImageView>(R.id.noticeImg)

// intent set to the variable 
        noticeName.text = name
        noticeDescription.text = description
        noticeImage.setImageResource(image)


    }
}
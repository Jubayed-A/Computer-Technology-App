package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NoticeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_details)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val image = intent.getIntExtra("image", R.drawable.img2)

        val noticeName = findViewById<TextView>(R.id.noticeName)
        val noticeDescription = findViewById<TextView>(R.id.noticeDescription)
        val noticeImage = findViewById<ImageView>(R.id.noticeImg)

        noticeName.text = name
        noticeDescription.text = description
        noticeImage.setImageResource(image)


    }
}
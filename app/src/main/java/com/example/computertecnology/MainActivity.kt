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

        val test = findViewById<CardView>(R.id.testAccount)

        test.setOnClickListener {
            val intentLog  = Intent(this, LogInActivity::class.java)
            startActivity(intentLog)
        }



    }
}
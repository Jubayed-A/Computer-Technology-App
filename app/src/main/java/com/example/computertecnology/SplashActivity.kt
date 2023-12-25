package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

// handle the time how many seconds it wait

        Handler().postDelayed({
            val intentMain = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intentMain)
        }, 2000)

    }
}
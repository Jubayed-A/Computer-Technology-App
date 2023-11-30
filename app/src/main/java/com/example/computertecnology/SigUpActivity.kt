package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SigUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sig_up_acitvity)

        val accountHave = findViewById<TextView>(R.id.haveAnAccount)

        accountHave.setOnClickListener {
            val intentSignIn = Intent(this, LogInActivity::class.java)
            startActivity(intentSignIn)
        }

    }
}
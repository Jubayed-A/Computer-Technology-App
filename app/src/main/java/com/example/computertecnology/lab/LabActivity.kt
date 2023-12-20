package com.example.computertecnology.lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.computertecnology.R

class LabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab)

        // variable declare
        val compute = findViewById<LinearLayout>(R.id.computerLab)
        val science = findViewById<LinearLayout>(R.id.scienceLab)
        val electric = findViewById<LinearLayout>(R.id.electricLab)
        val others = findViewById<LinearLayout>(R.id.othersLab)

        // computer lab activity
        compute.setOnClickListener {
            val intentComputer = Intent(this, ComputerLab::class.java)
            startActivity(intentComputer)
        }

        // science lab activity
        science.setOnClickListener {
            val intentScience = Intent(this, ScienceLab::class.java)
            startActivity(intentScience)
        }

        // electric lab activity
        electric.setOnClickListener {
            val intentElectric = Intent(this, ElectricLab::class.java)
            startActivity(intentElectric)
        }

        // others lab activity
        others.setOnClickListener {
            val intentOthers = Intent(this, OthersLab::class.java)
            startActivity(intentOthers)
        }

    }
}
package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ComputerLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var computerArrayList: ArrayList<Gallery>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_lab)

        recyclerView = findViewById(R.id.computerRecyclerView)

        // computer lab image declare
        val computerImageArray = arrayOf(
            R.drawable.lab1,
            R.drawable.lab2,
            R.drawable.lab3,
            R.drawable.lab4,
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized computer array list
        computerArrayList = arrayListOf<Gallery>()

        // add all data one by one to computerArrayList
        for (index in computerImageArray.indices) {
            val gallery = Gallery(computerImageArray[index])
            computerArrayList.add(gallery)
        }

        // for computer adapter code here
        val computerAdapter = GalleryAdapter(computerArrayList, this)
        recyclerView.adapter = computerAdapter

    }
}
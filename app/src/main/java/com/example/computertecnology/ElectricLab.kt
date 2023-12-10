package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ElectricLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var electricArrayList: ArrayList<Gallery>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electric_lab)

        recyclerView = findViewById(R.id.electricRecyclerView)

        // electric lab image declare
        val electricImageArray = arrayOf(
            R.drawable.lab1,
            R.drawable.lab2,
            R.drawable.lab3,
            R.drawable.lab4,
            R.drawable.lab5,
            R.drawable.lab6
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized electric array list
        electricArrayList = arrayListOf<Gallery>()

        // add all data one by one to electricArrayList
        for (index in electricImageArray.indices) {
            val gallery = Gallery(electricImageArray[index])
            electricArrayList.add(gallery)
        }

        // for electric adapter code here
        val electricAdapter = GalleryAdapter(electricArrayList, this)
        recyclerView.adapter = electricAdapter

    }
}
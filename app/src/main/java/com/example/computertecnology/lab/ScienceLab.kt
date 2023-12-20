package com.example.computertecnology.lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.gallery.Gallery
import com.example.computertecnology.gallery.GalleryAdapter
import com.example.computertecnology.R

class ScienceLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var scienceArrayList: ArrayList<Gallery>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science_lab)

        recyclerView = findViewById(R.id.scienceRecyclerView)

        // science lab image declare
        val scienceImageArray = arrayOf(
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
        // initialized science array list
        scienceArrayList = arrayListOf<Gallery>()

        // add all data one by one to scienceArrayList
        for (index in scienceImageArray.indices) {
            val gallery = Gallery(scienceImageArray[index])
            scienceArrayList.add(gallery)
        }

        // for science adapter code here
        val scienceAdapter = GalleryAdapter(scienceArrayList, this)
        recyclerView.adapter = scienceAdapter

    }
}
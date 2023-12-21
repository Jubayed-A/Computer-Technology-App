package com.example.computertecnology.lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.gallery.Gallery
import com.example.computertecnology.gallery.GalleryAdapter
import com.example.computertecnology.R

class DatabaseLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var scienceArrayList: ArrayList<Gallery>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science_lab)

        recyclerView = findViewById(R.id.scienceRecyclerView)

        // science lab image declare
        val scienceImageArray = arrayOf(
            R.drawable.database,
            R.drawable.database1,
            R.drawable.database2,
            R.drawable.database3,
            R.drawable.database4,
            R.drawable.database5,
            R.drawable.database6,
            R.drawable.database7,
            R.drawable.database8,
            R.drawable.database9,
            R.drawable.database10,
            R.drawable.database11,
            R.drawable.database12,
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
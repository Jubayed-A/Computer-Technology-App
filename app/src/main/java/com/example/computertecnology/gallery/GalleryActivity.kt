package com.example.computertecnology.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.R

class GalleryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var galleryArrayList: ArrayList<Gallery>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        recyclerView = findViewById(R.id.galleryRecyclerView)

        // notice image declare
        val galleryImageArray = arrayOf(
            R.drawable.lab1,
            R.drawable.lab2,
            R.drawable.lab3,
            R.drawable.lab4,
            R.drawable.lab5,
            R.drawable.lab6,
            R.drawable.lab7,
            R.drawable.lab8,
            R.drawable.lab9,
            R.drawable.lab10,
            R.drawable.lab11,
            R.drawable.lab12,
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized gallery array list
        galleryArrayList = arrayListOf<Gallery>()

        // add all data one by one to galleryArrayList
        for (index in galleryImageArray.indices) {
            val gallery = Gallery(galleryImageArray[index])
            galleryArrayList.add(gallery)
        }

        // for gallery adapter code here
        val galleryAdapter = GalleryAdapter(galleryArrayList, this)
        recyclerView.adapter = galleryAdapter

    }
}
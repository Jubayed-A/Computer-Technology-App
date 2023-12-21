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
            R.drawable.database,
            R.drawable.database1,
            R.drawable.database2,
            R.drawable.programming,
            R.drawable.programming1,
            R.drawable.programming2,
            R.drawable.programming3,
            R.drawable.programming4,
            R.drawable.programming5,
            R.drawable.programming6,
            R.drawable.database4,
            R.drawable.database5,
            R.drawable.database6,
            R.drawable.database7,
            R.drawable.hardware,
            R.drawable.hardware1,
            R.drawable.hardware2,
            R.drawable.hardware3,
            R.drawable.hardware4,
            R.drawable.hardware5,
            R.drawable.hardware6,
            R.drawable.networking,
            R.drawable.networking1,
            R.drawable.networking2,
            R.drawable.networking3,
            R.drawable.networking4,
            R.drawable.networking5,
            R.drawable.networking6,
            R.drawable.networking7,
            R.drawable.networking8,
            R.drawable.networking9,
            R.drawable.hardware7,
            R.drawable.hardware8,
            R.drawable.hardware9,
            R.drawable.hardware10,
            R.drawable.database8,
            R.drawable.database9,
            R.drawable.programming7,
            R.drawable.programming8,
            R.drawable.programming9,
            R.drawable.programming10,
            R.drawable.programming11,
            R.drawable.programming12,
            R.drawable.database3,
            R.drawable.database10,
            R.drawable.database11,
            R.drawable.database12,
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
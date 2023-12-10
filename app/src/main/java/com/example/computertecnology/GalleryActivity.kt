package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var galleryArrayList: ArrayList<Gallery>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        recyclerView = findViewById(R.id.galleryRecyclerView)

        // notice image declare
        val galleryImageArray = arrayOf(
            R.drawable.sample_img,
            R.drawable.img2,
            R.drawable.add,
            R.drawable.person_add_icon,
            R.drawable.computer2_lab_icon,
            R.drawable.science_lab2_icon
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized teacher array list
        galleryArrayList = arrayListOf<Gallery>()

        // add all data one by one to galleryArrayList
        for (index in galleryImageArray.indices){
            val gallery = Gallery(galleryImageArray[index])
            galleryArrayList.add(gallery)
        }


        // adapter code here
        val galleryAdapter = GalleryAdapter(galleryArrayList, this)
        recyclerView.adapter = galleryAdapter


    }
}
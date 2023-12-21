package com.example.computertecnology.lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.gallery.Gallery
import com.example.computertecnology.gallery.GalleryAdapter
import com.example.computertecnology.R

class HardwareLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var othersArrayList: ArrayList<Gallery>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_others_lab)

        recyclerView = findViewById(R.id.othersRecyclerView)

        // others lab image declare
        val othersImageArray = arrayOf(
            R.drawable.hardware,
            R.drawable.hardware1,
            R.drawable.hardware2,
            R.drawable.hardware3,
            R.drawable.hardware4,
            R.drawable.hardware5,
            R.drawable.hardware6,
            R.drawable.hardware7,
            R.drawable.hardware8,
            R.drawable.hardware9,
            R.drawable.hardware10,
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized others array list
        othersArrayList = arrayListOf<Gallery>()

        // add all data one by one to othersArrayList
        for (index in othersImageArray.indices) {
            val gallery = Gallery(othersImageArray[index])
            othersArrayList.add(gallery)
        }

        // for others adapter code here
        val othersAdapter = GalleryAdapter(othersArrayList, this)
        recyclerView.adapter = othersAdapter

    }
}
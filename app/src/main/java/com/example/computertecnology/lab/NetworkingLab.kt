package com.example.computertecnology.lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.gallery.Gallery
import com.example.computertecnology.gallery.GalleryAdapter
import com.example.computertecnology.R

class NetworkingLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var electricArrayList: ArrayList<Gallery>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electric_lab)

        recyclerView = findViewById(R.id.electricRecyclerView)

        // electric lab image declare
        val electricImageArray = arrayOf(
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
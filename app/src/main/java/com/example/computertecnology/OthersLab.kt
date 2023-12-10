package com.example.computertecnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OthersLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var othersArrayList: ArrayList<Gallery>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_others_lab)

        recyclerView = findViewById(R.id.othersRecyclerView)

        // others lab image declare
        val othersImageArray = arrayOf(
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
package com.example.computertecnology.lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.gallery.Gallery
import com.example.computertecnology.gallery.GalleryAdapter
import com.example.computertecnology.R

class ProgrammingLab : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var computerArrayList: ArrayList<Gallery>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_lab)

        recyclerView = findViewById(R.id.computerRecyclerView)

        // computer lab image declare
        val computerImageArray = arrayOf(
            R.drawable.programming,
            R.drawable.programming1,
            R.drawable.programming2,
            R.drawable.programming3,
            R.drawable.programming4,
            R.drawable.programming5,
            R.drawable.programming6,
            R.drawable.programming7,
            R.drawable.programming8,
            R.drawable.programming9,
            R.drawable.programming10,
            R.drawable.programming11,
            R.drawable.programming12,
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
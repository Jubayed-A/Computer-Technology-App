package com.example.computertecnology

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class TeacherAdapter (private var teacherArrayList: ArrayList<Teacher>, var context: Activity) :
    RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>(){
    class TeacherViewHolder(teacherView: View) : RecyclerView.ViewHolder(teacherView) {
        val tName = teacherView.findViewById<TextView>(R.id.personName)
        val tProf = teacherView.findViewById<TextView>(R.id.personProf)
        val tImage = teacherView.findViewById<ShapeableImageView>(R.id.imageProfile)
    }

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val teacherView = LayoutInflater.from(parent.context).inflate(R.layout.custom_card_view, parent, false)
        return TeacherViewHolder(teacherView)
    }

    // how many item are there in teacherArrayList
    override fun getItemCount(): Int {
        return teacherArrayList.size
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val currentTeacher = teacherArrayList[position]
        holder.tName.text = currentTeacher.teacherName
        holder.tProf.text = currentTeacher.teacherProf
        holder.tImage.setImageResource(currentTeacher.teacherImg)
    }

}
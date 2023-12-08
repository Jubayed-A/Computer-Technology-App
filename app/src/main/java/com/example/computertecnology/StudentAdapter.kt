package com.example.computertecnology

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class StudentAdapter(private var studentArrayList: ArrayList<Data>, var context: Activity) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private lateinit var studentListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: StudentAdapter.onItemClickListener) {
        studentListener = listener
    }

    // student view holder
    class StudentViewHolder(studentView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(studentView) {
        val sName = studentView.findViewById<TextView>(R.id.personName)
        val sProf = studentView.findViewById<TextView>(R.id.personProf)
        val sImage = studentView.findViewById<ShapeableImageView>(R.id.imageProfile)

        init {
            studentView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }

    }

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val studentView =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_card_view, parent, false)
        return StudentViewHolder(studentView, studentListener)
    }

    // how many item are there in teacherArrayList
    override fun getItemCount(): Int {
        return studentArrayList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = studentArrayList[position]
        holder.sName.text = currentStudent.name
        holder.sProf.text = currentStudent.prof
        holder.sImage.setImageResource(currentStudent.image)
    }

}
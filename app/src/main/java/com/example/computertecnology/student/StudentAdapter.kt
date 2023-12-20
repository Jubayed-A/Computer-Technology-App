package com.example.computertecnology.student

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.R

class StudentAdapter(private var studentArrayList: ArrayList<StdData>, var context: Activity) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // student view holder
    class StudentViewHolder(studentView: View) :
        RecyclerView.ViewHolder(studentView) {
        val sName = studentView.findViewById<TextView>(R.id.stdName)
        val sRoll = studentView.findViewById<TextView>(R.id.stdRoll)
        val sSection = studentView.findViewById<TextView>(R.id.stdSection)
        val sDepartment = studentView.findViewById<TextView>(R.id.stdDepartment)
        val sSemester = studentView.findViewById<TextView>(R.id.stdSemester)
        val sPhone = studentView.findViewById<TextView>(R.id.stdPhone)

    }

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val studentView =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_student_view, parent, false)
        return StudentViewHolder(studentView)
    }

    // how many item are there in teacherArrayList
    override fun getItemCount(): Int {
        return studentArrayList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = studentArrayList[position]
        holder.sName.text = currentStudent.name
        holder.sRoll.text = currentStudent.roll
        holder.sSection.text = currentStudent.section
        holder.sDepartment.text = currentStudent.department
        holder.sSemester.text = currentStudent.semester
        holder.sPhone.text = currentStudent.phone
    }

}
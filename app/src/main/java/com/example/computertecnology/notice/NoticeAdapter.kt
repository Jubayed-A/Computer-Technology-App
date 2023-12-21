package com.example.computertecnology.notice

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.Data
import com.example.computertecnology.R
import com.google.android.material.imageview.ShapeableImageView

class NoticeAdapter(private var noticeArrayList: ArrayList<Data>, var context: Activity) :
    RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    private lateinit var noticeListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClicking(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        noticeListener = listener
    }


    class NoticeViewHolder(noticeView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(noticeView) {
        val nTitle = noticeView.findViewById<TextView>(R.id.noticeTitle)
        val nSubTitle = noticeView.findViewById<TextView>(R.id.noticeSubTitle)
        val nImage = noticeView.findViewById<ShapeableImageView>(R.id.noticeImg)

        init {
            noticeView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val noticeView =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_notice_view, parent, false)
        return NoticeViewHolder(noticeView, noticeListener)
    }

    // how many item are there in teacherArrayList
    override fun getItemCount(): Int {
        return noticeArrayList.size
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val currentTeacher = noticeArrayList[position]
        holder.nTitle.text = currentTeacher.name
        holder.nSubTitle.text = currentTeacher.prof
        holder.nImage.setImageResource(currentTeacher.image)
    }

}
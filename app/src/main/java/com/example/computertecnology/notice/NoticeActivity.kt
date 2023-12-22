package com.example.computertecnology.notice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.Data
import com.example.computertecnology.R

class NoticeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noticeArrayList: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)

        // recyclerView declare
        recyclerView = findViewById(R.id.noticeRecyclerView)

        // notice image declare
        val noticeImageArray = arrayOf(
            R.drawable.notice_exam,
            R.drawable.notice1,
            R.drawable.notice4,
            R.drawable.notice2,
            R.drawable.notice3,
        )

        // notice name declare
        val noticeTitleArray = arrayOf(
            "Exam Notice",
            "Bijoy Dibos Notice",
            "Pending Due Notice",
            "21st February notice",
            "Shadinota Dibos"
        )

        // notice prof declare
        val noticeSubTitleArray = arrayOf(
            "Chief Instructor(CI)",
            "16 December bijoy dibos notice ",
            "Senior Instructor",
            "Senior Instructor",
            "Senior Instructor",
        )

        // notice description
        val noticeDescriptionArray = arrayOf(
            "Shahinur islam Shahin is Chief instructor of computer department ",
            "Plolas Chondro Biswas is a Senior Instructor of computer department",
            "Plolas Chondro Biswas is a Senior Instructor of computer department",
            "Plolas Chondro Biswas is a Senior Instructor of computer department",
            "Plolas Chondro Biswas is a Senior Instructor of computer department",
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized teacher array list
        noticeArrayList = arrayListOf<Data>()

        // add all data one by one to teacherArrayList
        for (index in noticeImageArray.indices){
            val notice = Data(noticeTitleArray[index], noticeImageArray[index], noticeSubTitleArray[index], noticeDescriptionArray[index])
            noticeArrayList.add(notice)
        }

        // adapter code here
        val noticeAdapter = NoticeAdapter(noticeArrayList, this)
        recyclerView.adapter = noticeAdapter

        // click on each teacher
        noticeAdapter.setOnItemClickListener(object : NoticeAdapter.onItemClickListener{
            override fun onItemClicking(position: Int) {
                // on clicking each teacher what action do you want to perform
                val intentNoticeProfile = Intent(this@NoticeActivity, NoticeDetails::class.java)
                intentNoticeProfile.putExtra("name", noticeArrayList[position].name)
                intentNoticeProfile.putExtra("description", noticeArrayList[position].description)
                intentNoticeProfile.putExtra("image", noticeArrayList[position].image)
                startActivity(intentNoticeProfile)
            }

        })

    }
}
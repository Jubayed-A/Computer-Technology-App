package com.example.computertecnology

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.computertecnology.TeacherAdapter.onItemClickListener

class NoticeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noticeArrayList: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)

        recyclerView = findViewById(R.id.noticeRecyclerView)

        // notice image declare
        val noticeImageArray = arrayOf(
            R.drawable.sample_img,
            R.drawable.img2
        )

        // notice name declare
        val noticeNameArray = arrayOf(
            "Sahinur Islam Sahin",
            "Polash Chandro Bisswas"
        )

        // notice prof declare
        val noticeProfArray = arrayOf(
            "Chief Instructor(CI)",
            "Senior Instructor"
        )

        // notice description
        val noticeDescriptionArray = arrayOf(
            "Shahinur islam shain is Chief instructor of computer department ",
            "Plolas Chondro Biswas is a Senior Instructor of computer department"
        )

        // to set behave of item inside recyclerview
        // layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // initialized teacher array list
        noticeArrayList = arrayListOf<Data>()

        // add all data one by one to teacherArrayList
        for (index in noticeImageArray.indices){
            val notice = Data(noticeNameArray[index], noticeImageArray[index], noticeProfArray[index], noticeDescriptionArray[index])
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
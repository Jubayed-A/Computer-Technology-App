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
            "Victory Day Notice",
            "Pending Due Notice",
            "21st February Notice",
            "Independence Day Notice"
        )

        // notice prof declare
        val noticeSubTitleArray = arrayOf(
            "SIPI Final Semester Exam Notice 2023",
            "Victory Day Notice in 16 December 2023",
            "Complete The Pending Due immediately",
            "Notice for International Mother Language",
            "Independence Day Notice in 26 March 2023",
        )

        // notice description
        val noticeDescriptionArray = arrayOf(
            getString(R.string.exam_notice_description),
            getString(R.string.victory_notice_description),
            getString(R.string.due_payment_notice),
            getString(R.string.february_21st),
            getString(R.string.notice_for_independence_day),
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
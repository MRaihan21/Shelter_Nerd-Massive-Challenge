package com.xet.ui.profile.DetailProfile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Activity.Detail.ActivityFestivalDetail
import com.xet.Adapter.FeedbackAdapter
import com.xet.Adapter.FestivalAdapter
import com.xet.Models.FeedbackModel
import com.xet.Models.FestivalModel
import com.xet.R
import com.xet.databinding.ActivityFeedbackBinding
import com.xet.databinding.ActivityFestivalDetailBinding
import com.xet.ui.home.HomeFragment

class FeedbackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding

    private lateinit var feedbackList: ArrayList<FeedbackModel>

    lateinit var date: Array<String>
    lateinit var name: Array<String>
    lateinit var image: Array<Int>
    lateinit var rating: Array<Float>
    lateinit var comment: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_feedback)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = FeedbackAdapter(feedbackList){

        }

    }

    private fun dataInitialize() {
        feedbackList = arrayListOf<FeedbackModel>()

        date = arrayOf(
            "21 September 2023",
        )
        name = arrayOf(
            "Gatot",
        )
        image = arrayOf(
            R.drawable.ic_music,
        )
        rating = arrayOf(
           5F,
        )
        comment = arrayOf(
            "Eventnya seru",
        )

        for (i in date.indices){
            val feedback = FeedbackModel(
               date[i],
                name[i],
                image[i],
                rating[i],
                comment[i]
            )
            feedbackList.add(feedback)
        }

    }

}
package com.xet.ui.home.other

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xet.Activity.MainActivity
import com.xet.R
import com.xet.databinding.ActivityFeedback2ActivityBinding
import com.xet.ui.profile.DetailProfile.FeedbackActivity

class Feedback2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedback2ActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback2_activity)

        binding = ActivityFeedback2ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnNextFeedback.setOnClickListener {
//            startActivity(Intent(this, FeedbackActivity::class.java))
//        }

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
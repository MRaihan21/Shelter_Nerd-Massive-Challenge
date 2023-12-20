package com.xet.ui.home.other

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xet.R
import com.xet.databinding.ActivityFeedback1ActiivtyBinding

class Feedback1Actiivty : AppCompatActivity() {

    private lateinit var binding: ActivityFeedback1ActiivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback1_actiivty)

        binding = ActivityFeedback1ActiivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnSubmit.setOnClickListener{
            startActivity(Intent(this, Feedback2Activity::class.java))
        }
    }
}
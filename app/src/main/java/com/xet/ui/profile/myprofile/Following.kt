package com.xet.ui.profile.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xet.R
import com.xet.databinding.ActivityFollowingBinding

class Following : AppCompatActivity() {

    private lateinit var binding : ActivityFollowingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFollowingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
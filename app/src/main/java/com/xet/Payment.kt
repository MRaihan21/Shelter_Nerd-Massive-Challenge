package com.xet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xet.databinding.ActivityPaymentBinding

class Payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
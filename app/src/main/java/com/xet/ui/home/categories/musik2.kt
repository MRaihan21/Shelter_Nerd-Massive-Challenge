package com.xet.ui.home.categories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xet.Creator
import com.xet.LocationActivity
import com.xet.Payment
import com.xet.PaymentFragment
import com.xet.R
import com.xet.databinding.ActivityMusik2Binding

class musik2 : AppCompatActivity() {

    private lateinit var binding: ActivityMusik2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMusik2Binding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.btnLocation.setOnClickListener {
                val intent = Intent(this, LocationActivity::class.java)
                startActivity(intent)
            }
            binding.creator.setOnClickListener {
                val intent = Intent(this, Creator::class.java)
                startActivity(intent)
            }
            binding.btnBuyNow.setOnClickListener {
            val intent = Intent(this, Payment::class.java)
            startActivity(intent)
            }
    }
}
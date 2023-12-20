
package com.xet.ui.profile.DetailProfile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xet.R
import com.xet.databinding.ActivityDetailProfileBinding

class DetailProfile : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProfileBinding
    private var selectedImageUrl: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_profile)

        binding = ActivityDetailProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
                onBackPressed()
        }
        binding.btnEditProfile.setOnClickListener {
            onBackPressed()
        }
        binding.imageView2.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val url = data?.data
            if (url != null) {
                binding.imageView2.setImageURI(url)

                selectedImageUrl = url
            }
        }
    }
}
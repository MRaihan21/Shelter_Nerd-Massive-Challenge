package com.xet.Activity.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.xet.Models.JapaneseModel
import com.xet.Models.MusicModel
import com.xet.R
import com.xet.databinding.ActivityJapaneseDetailBinding
import com.xet.databinding.ActivityMusicDetailBinding
import com.xet.ui.home.HomeFragment

class ActivityJapaneseDetail : AppCompatActivity() {

    private lateinit var binding : ActivityJapaneseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_japanese_detail)

        binding = ActivityJapaneseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }
        binding.creator.setOnClickListener{
            startActivity(Intent(this, CreatorDetailActivity::class.java))
        }

        val Japanese = intent.getParcelableExtra<JapaneseModel>(HomeFragment.INTENT_PARCELABLE)

        val img = findViewById<ImageView>(R.id.iv_cover)
        val title = findViewById<TextView>(R.id.tv_title_event_detail)
        val price = findViewById<TextView>(R.id.tv_price_detail)

        val imgcreator = findViewById<ImageView>(R.id.imageview)
        val creator = findViewById<TextView>(R.id.tv_creator)
        val desc = findViewById<TextView>(R.id.tv_desc_detail)
        val location = findViewById<TextView>(R.id.btn_location)
        val date = findViewById<TextView>(R.id.tv_date)
        val time = findViewById<TextView>(R.id.tv_time)
        val type = findViewById<TextView>(R.id.tv_event_type)


        //japanese
        img.setImageResource(Japanese?.img!!)
        title.text = Japanese.title
        price.text = Japanese.price

        imgcreator.setImageResource(Japanese.imgCreator)
        creator.text = Japanese.creator
        location.text = Japanese.location
        desc.text = Japanese.desc
        date.text = Japanese.date
        time.text = Japanese.time
        type.text = Japanese.type

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
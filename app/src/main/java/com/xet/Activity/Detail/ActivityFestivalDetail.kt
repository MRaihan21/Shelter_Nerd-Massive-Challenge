package com.xet.Activity.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.xet.Activity.Detail.other.CreatorDetailActivity
import com.xet.Activity.Detail.other.PaymentActivity
import com.xet.Models.FestivalModel
import com.xet.R
import com.xet.databinding.ActivityFestivalDetailBinding
import com.xet.ui.home.HomeFragment

class ActivityFestivalDetail : AppCompatActivity() {

    private lateinit var binding : ActivityFestivalDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_festival_detail)

        binding = ActivityFestivalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }
        binding.creator.setOnClickListener{
            startActivity(Intent(this, CreatorDetailActivity::class.java))
        }
        binding.btnBuyNow.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }


        val festival = intent.getParcelableExtra<FestivalModel>(HomeFragment.INTENT_PARCELABLE)

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


        //music
        img.setImageResource(festival?.img!!)
        title.text = festival.title
        price.text = festival.price

        imgcreator.setImageResource(festival.imgCreator)
        creator.text = festival.creator
        location.text = festival.location
        desc.text = festival.desc
        date.text = festival.date
        time.text = festival.time
        type.text = festival.type

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
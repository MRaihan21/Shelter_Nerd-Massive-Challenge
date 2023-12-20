package com.xet.Activity.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.xet.Activity.Detail.other.CreatorDetailActivity
import com.xet.Activity.Detail.other.PaymentActivity
import com.xet.MapsActivity
import com.xet.Models.CreatorModel
import com.xet.Models.MusicModel
import com.xet.R
import com.xet.databinding.ActivityMusicDetailBinding
import com.xet.ui.home.HomeFragment

class ActivityMusicDetail : AppCompatActivity() {

    private lateinit var binding : ActivityMusicDetailBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var creatorList: ArrayList<CreatorModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)

        binding = ActivityMusicDetailBinding.inflate(layoutInflater)
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



        val Music = intent.getParcelableExtra<MusicModel>(HomeFragment.INTENT_PARCELABLE)

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
        img.setImageResource(Music?.img!!)
        title.text = Music.title
        price.text = Music.price

        imgcreator.setImageResource(Music.imgCreator)
        creator.text = Music.creator
        location.text = Music.location
        desc.text = Music.desc
        date.text = Music.date
        time.text = Music.time
        type.text = Music.type

        binding.btnLocation.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
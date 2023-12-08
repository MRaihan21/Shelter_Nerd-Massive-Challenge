package com.xet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.xet.data.CategoriesMusicData
import com.xet.ui.home.HomeFragment

class ActivityEVentDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        val CategoriesMusicData = intent.getParcelableExtra<CategoriesMusicData>(HomeFragment.INTENT_PARCELABLE)


        val creatorEvent = findViewById<TextView>(R.id.tv_creator)
        val location = findViewById<Button>(R.id.btn_location)
        val desc = findViewById<TextView>(R.id.tv_desc_detail)
        val dateEvent = findViewById<TextView>(R.id.tv_date)
        val time = findViewById<TextView>(R.id.tv_time)
        val type = findViewById<TextView>(R.id.tv_event_type)

//        creatorEvent.text = CategoriesEventData?.creator
//        location.text = CategoriesEventData?.location
//        desc.text = CategoriesEventData?.desc
//        dateEvent.text = CategoriesEventData?.date
//        time.text = CategoriesEventData?.time
//        type.text = CategoriesEventData?.type

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
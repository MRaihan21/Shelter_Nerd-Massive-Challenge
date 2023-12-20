package com.xet.Activity.Detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Adapter.CreatorAdapter
import com.xet.Models.CreatorModel
import com.xet.R
import com.xet.databinding.ActivityCreatorDetailBinding

class CreatorDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatorDetailBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var desc: Array<String>

    private lateinit var creatorList: ArrayList<CreatorModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creator_detail)

        binding = ActivityCreatorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_creator_detail)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CreatorAdapter(creatorList) {

        }

    }

    private fun dataInitialize() {
        creatorList = arrayListOf<CreatorModel>()

        image = arrayOf(
            R.drawable.ic_music,
        )

        title = arrayOf(
            "Hellocalize Festival",
        )

        desc = arrayOf(
            "Hellocalize Festival adalah pengalaman konser unik yang memadukan berbagai genre musik dari seniman lokal dan internasional. Nikmati malam yang penuh kegembiraan dengan penampilan live yang memukau di lokasi yang dipilih dengan cermat.",
        )
        for (i in image.indices) {
            val creator = CreatorModel(
                image[i],
                title[i],
                desc[i],
            )
            creatorList.add(creator)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
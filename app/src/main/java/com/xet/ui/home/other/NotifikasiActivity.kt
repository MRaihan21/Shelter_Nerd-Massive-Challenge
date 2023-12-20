package com.xet.ui.home.other

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Adapter.CreatorAdapter
import com.xet.Adapter.NotifAdapter
import com.xet.Models.CreatorModel
import com.xet.Models.NotifModel
import com.xet.R
import com.xet.databinding.ActivityNotifikasiBinding

class NotifikasiActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNotifikasiBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    lateinit var image: Array<Int>
    lateinit var message: Array<String>
    lateinit var date: Array<String>

    private lateinit var notifList: ArrayList<NotifModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifikasi)

        binding = ActivityNotifikasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_notif)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = NotifAdapter(notifList) {
            startActivity(Intent(this, Feedback1Actiivty::class.java))
        }


    }

    private fun dataInitialize() {
        notifList = arrayListOf<NotifModel>()

        image = arrayOf(
            R.drawable.ic_music,
        )

        message = arrayOf(
            "Event yang sudah kamu ikuti sudah selasai!! Silahkan beri rating untuk event ini.",
        )

        date = arrayOf(
            "21 Sep 2023",
        )
        for (i in image.indices) {
            val notif = NotifModel(
                image[i],
                message[i],
                date[i],
            )
            notifList.add(notif)
        }
    }

}
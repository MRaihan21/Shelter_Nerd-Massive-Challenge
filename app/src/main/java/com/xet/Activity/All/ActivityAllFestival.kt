package com.xet.Activity.All

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Activity.Detail.ActivityFestivalDetail
import com.xet.Adapter.FestivalAdapter
import com.xet.Models.FestivalModel
import com.xet.R
import com.xet.databinding.ActivityAllFestivalBinding
import com.xet.ui.home.HomeFragment

class ActivityAllFestival : AppCompatActivity() {

    private lateinit var binding: ActivityAllFestivalBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var festivalList: ArrayList<FestivalModel>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var price: Array<String>

    lateinit var imgCreator: Array<Int>
    lateinit var creator : Array<String>
    lateinit var location : Array<String>
    lateinit var desc : Array<String>
    lateinit var date : Array<String>
    lateinit var time : Array<String>
    lateinit var type : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAllFestivalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_categories_festival)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = FestivalAdapter(festivalList) {
            val intent = Intent(this, ActivityFestivalDetail::class.java)
            intent.putExtra(HomeFragment.INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        festivalList = arrayListOf<FestivalModel>()

        image = arrayOf(
            R.drawable.ic_festival,
            R.drawable.ic_festival2,
            R.drawable.ic_festival3,
            R.drawable.ic_festival4,
        )

        title = arrayOf(
            "Festival Budaya",
            "Budaya International",
            "Cultural Festival",
            "Blangkon Festival",
        )

        price = arrayOf(
            "Rp.75.000",
            "Rp.25.000",
            "Rp.80.000",
            "Rp.100.000",
        )

        imgCreator = arrayOf(
            R.drawable.ic_festival,
            R.drawable.ic_festival2,
            R.drawable.ic_festival3,
            R.drawable.ic_festival4,
        )

        creator = arrayOf(
            "Agarta",
            "Utopia",
            "Culcutal Festival",
            "Blangkon",
        )

        location = arrayOf(
            "Pontianak",
            "BalikPapan",
            "Makassar",
            "Malang",
        )

        desc = arrayOf(
            "Festival Budaya memukau dengan pertunjukan tarian tradisional, seni rakyat, dan kuliner autentik. Suasana penuh warna merayakan warisan budaya yang kaya dan menarik",
            "Festival Budaya mengajak pengunjung dalam perjalanan melalui kearifan lokal. Nikmati pertunjukan tarian etnik, kuliner khas, dan pameran seni yang memperkuat identitas dan keberagaman budaya",
            "Cultural Festival memadukan keunikan budaya dalam pagelaran seni, pertunjukan musik, dan pameran kreatif. Sambutlah pengalaman tak terlupakan yang memperkaya pemahaman akan keberagaman budaya.",
            "Blangkon Festival memukau dengan perpaduan seni tradisional dan modern. Para peserta menghadirkan keindahan blangkon dalam berbagai kreativitas, menciptakan acara yang meriah dan berwarna",
        )

        date = arrayOf(
            "23 Mar 2023",
            "29 Mei 2023",
            "04 Mar 2023",
            "24 Apr 2023",
        )

        time = arrayOf(
            "20.00-22.00",
            "09.00-10.00",
            "16.00-18.00",
            "12.00-14.00",
        )

        type = arrayOf(
            "Offline",
            "Offline",
            "Offline",
            "Offline",
        )



        for (i in image.indices){
            val festival = FestivalModel(
                image[i],
                title[i],
                price[i],
                imgCreator[i],
                creator[i],
                location[i],
                desc[i],
                date[i],
                time[i],
                type[i]
            )
            festivalList.add(festival)
        }

    }

}
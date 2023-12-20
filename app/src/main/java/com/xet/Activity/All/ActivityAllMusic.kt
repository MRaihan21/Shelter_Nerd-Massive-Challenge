package com.xet.Activity.All

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Activity.Detail.ActivityMusicDetail
import com.xet.Adapter.MusicAdapter
import com.xet.Models.MusicModel
import com.xet.R
import com.xet.databinding.ActivityAllMusicBinding
import com.xet.ui.home.HomeFragment

class ActivityAllMusic : AppCompatActivity() {

    private lateinit var binding : ActivityAllMusicBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var musicList: ArrayList<MusicModel>

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

        binding = ActivityAllMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_categories_music)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MusicAdapter(musicList) {
            val intent = Intent(this, ActivityMusicDetail::class.java)
            intent.putExtra(HomeFragment.INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        musicList = arrayListOf<MusicModel>()

        image = arrayOf(
            R.drawable.ic_music,
            R.drawable.ic_music2,
            R.drawable.ic_music3,
            R.drawable.ic_music4,
        )

        title = arrayOf(
            "Hellocalize Festival",
            "Panggung Panas",
            "Festival Music",
            "Drew Band",
        )

        price = arrayOf(
            "Rp.200.000",
            "Rp.50.000",
            "Rp.120.000",
            "Rp.250.000",
        )

        imgCreator = arrayOf(
            R.drawable.hellocalize,
            R.drawable.pangpan,
            R.drawable.ic_music3,
            R.drawable.ic_music4,
        )

        creator = arrayOf(
            "Hellocalize",
            "Pidjar Karya",
            "Enjoy Music",
            "Music Festival",
        )

        location = arrayOf(
            "Malang",
            "Jakarta",
            "Bandung",
            "Medan",
        )

        desc = arrayOf(
            "Hellocalize Festival adalah pengalaman konser unik yang memadukan berbagai genre musik dari seniman lokal dan internasional. Nikmati malam yang penuh kegembiraan dengan penampilan live yang memukau di lokasi yang dipilih dengan cermat.",
            "Panggung Panas merupakan konser musik perpaduan indie, pop dan koplo. Kolaborasi antara musisi dan grup musik tanah air",
            "Merayakan ritme hidup dengan festival musik penuh semangat. Saksikan penampilan langsung dari bintang-bintang musik terkemuka dalam perayaan suara dan kegembiraan yang tak terlupakan.",
            "Festival musik: Pengalaman seni terbaik di bawah langit terbuka. Bergabunglah dengan ribuan penggemar musik untuk menikmati live performance, interaksi sosial, dan pesta tak terlupakan.",
        )

        date = arrayOf(
            "21 Sep 2022",
            "09 Nov 2023",
            "11 Okt 2023",
            "20 Des 2023",
        )

        time = arrayOf(
            "20.00-22.00",
            "17.00-20.00",
            "19.00-20.00",
            "19.00-21.00",
        )

        type = arrayOf(
            "Offline",
            "Offline",
            "Offline",
            "Offline",
        )



        for (i in image.indices) {
            val music = MusicModel(
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
            musicList.add(music)

        }
    }
}
package com.xet.Activity.All

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Activity.Detail.ActivityJapaneseDetail
import com.xet.Adapter.JapaneseAdapter
import com.xet.Models.JapaneseModel
import com.xet.R
import com.xet.databinding.ActivityAllJapaneseBinding
import com.xet.ui.home.HomeFragment

class ActivityAllJapanese : AppCompatActivity() {

    private lateinit var binding: ActivityAllJapaneseBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var japaneseList: ArrayList<JapaneseModel>

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

        binding = ActivityAllJapaneseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_categories_japanese)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = JapaneseAdapter(japaneseList) {
            val intent = Intent(this, ActivityJapaneseDetail::class.java)
            intent.putExtra(HomeFragment.INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        japaneseList = arrayListOf<JapaneseModel>()

        image = arrayOf(
            R.drawable.ic_japanese,
            R.drawable.ic_japanese2,
            R.drawable.ic_japanese3,
            R.drawable.ic_japanese4,
        )

        title = arrayOf(
            "Cosplay Event",
            "Cosplay Competition",
            "Cosplay Night",
            "Festival Pop x Japan",
        )

        price = arrayOf(
            "Rp.100.000",
            "Rp.120.000",
            "Rp.80.000",
            "Rp.70.000",
        )

        imgCreator = arrayOf(
            R.drawable.ic_japanese,
            R.drawable.wakuwaku,
            R.drawable.ic_japanese3,
            R.drawable.hajimari,
        )

        creator = arrayOf(
            "Joryu Eatadakimasu",
            "Waku waku",
            "Event Copslay",
            "Aki No Hajimari",
        )

        location = arrayOf(
            "Yogyakarta",
            "Batam",
            "Pekanbaru",
            "Banjarmasin",
        )

        desc = arrayOf(
            "Hadiri Japan Festival dan rasakan getaran kreativitas Jepang melalui cosplay competition yang mengesankan, Coswalk junior comp yang menggemaskan, dan karaoke competition yang memukau. Suatu pengalaman luar biasa untuk semua.",
            "Dalam Japan Festival, saksikan pesona cosplay anime yang luar biasa. Para peserta menampilkan dedikasi mereka melalui kostum dan penampilan yang menakjubkan, menciptakan atmosfer penuh semangat dan keceriaan",
            "ejepangan cosplay mempersembahkan karnaval warna-warni dan kreativitas. Para peserta dengan penuh semangat membawa kehidupan pada karakter anime, menciptakan momen kegembiraan di setiap detik.",
            "Selamat datang di Festival Kebudayaan Jepang, di mana pesona Negeri Matahari Terbit menyatu dalam pagelaran seni, kuliner autentik, dan pertunjukan tradisional. Suasana khas Jepang memikat hati.",
        )

        date = arrayOf(
            "05 Jan 2023",
            "01 Okt 2023",
            "10 Apr 2023",
            "20 Agus 2023",
        )

        time = arrayOf(
            "14.00-17.00",
            "14.00-16.30",
            "01.00- 21.00",
            "09.00-14.00",
        )

        type = arrayOf(
            "Offline",
            "Offline",
            "Offline",
            "Offline",
        )



        for (i in image.indices){
            val japanese = JapaneseModel(
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
            japaneseList.add(japanese)
        }

    }

}
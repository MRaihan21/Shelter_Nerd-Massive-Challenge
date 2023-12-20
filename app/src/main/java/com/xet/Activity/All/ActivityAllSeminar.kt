package com.xet.Activity.All

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Activity.Detail.ActivitySeminarDetail
import com.xet.Adapter.SeminarAdapter
import com.xet.Models.SeminarModel
import com.xet.R
import com.xet.databinding.ActivityAllSeminarBinding
import com.xet.ui.home.HomeFragment

class ActivityAllSeminar : AppCompatActivity() {

    private lateinit var binding: ActivityAllSeminarBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var seminarList: ArrayList<SeminarModel>

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

        binding = ActivityAllSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
           onBackPressed()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_categories_seminar)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SeminarAdapter(seminarList) {
            val intent = Intent(this, ActivitySeminarDetail::class.java)
            intent.putExtra(HomeFragment.INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        seminarList = arrayListOf<SeminarModel>()

        image = arrayOf(
            R.drawable.ic_seminar,
            R.drawable.ic_seminar2,
            R.drawable.ic_seminar3,
            R.drawable.ic_seminar4,
        )

        title = arrayOf(
            "Seminar Pendidikan",
            "Seminar Pendidikan",
            "Bussines Insight",
            "Online Bussines",
        )

        price = arrayOf(
            "FREE",
            "Rp.50.000",
            "Rp.50.000",
            "Rp.80.000",
        )

        imgCreator = arrayOf(
            R.drawable.ic_seminar,
            R.drawable.ic_seminar2,
            R.drawable.ic_seminar3,
            R.drawable.ic_seminar4,
        )

        creator = arrayOf(
            "Seminar Pnedidikan",
            "Seminar Landscape",
            "Silince Mode On",
            "Bussines Conference",
        )

        location = arrayOf(
            "Jakarta",
            "Malang",
            "Bandung",
            "Pekanbaru",
        )

        desc = arrayOf(
            "Ikuti Seminar Pendidikan untuk mendalami tren terbaru dan inovasi pendidikan. Dapatkan wawasan berharga dari para ahli, tanpa batas ruang dan waktu.",
            "Seminar Pendidikan Online membahas inklusi dan keadilan pendidikan. Dengan para ahli di bidangnya, temukan cara meningkatkan akses dan kualitas pendidikan bagi semua.",
            "Seminar Business Online membawa wawasan global ke bisnis lokal. Pelajari strategi pengembangan bisnis yang dapat disesuaikan dengan kebutuhan pasar lokal dan global",
            "Seminar Business Online membahas strategi pemasaran digital dan pengembangan bisnis online. Ikuti untuk mendapatkan wawasan dan alat praktis yang dapat diterapkan segera.",
        )

        date = arrayOf(
            "01 Des 2023",
            "24 Agus 2023",
            "21 Okt 2023",
            "07 Jun 2023",
        )

        time = arrayOf(
            "09.00-10.00",
            "10.00-11.30",
            "012.00-10.00",
            "09.00-10.00",
        )

        type = arrayOf(
            "Offline",
            "Online",
            "Online",
            "Online",
        )



        for (i in image.indices){
            val seminar = SeminarModel(
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
            seminarList.add(seminar)
        }

    }

}
package com.xet.ui.home.categories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.MainActivity
import com.xet.R
import com.xet.adapter.CategoriesSeminarAdapter
import com.xet.data.CategoriesSeminarData
import com.xet.databinding.ActivityCategoriesSeminarBinding

class CategoriesSeminar : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesSeminarBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var seminarArrayList : ArrayList<CategoriesSeminarData>
    private lateinit var adapterSeminar: CategoriesSeminarAdapter

    lateinit var img1: Array<Int>
    lateinit var titleEvent1 : Array<String>
    lateinit var price1 : Array<String>

//    lateinit var creatorEvent: Array<String>
//    lateinit var location: Array<String>
//    lateinit var desc: Array<String>
//    lateinit var dateEvent: Array<String>
//    lateinit var time: Array<String>
//    lateinit var type: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize3()

        val layoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = findViewById(R.id.rv_categories_seminar)
        recyclerView.layoutManager = layoutManager3
        recyclerView.setHasFixedSize(true)
        adapterSeminar = CategoriesSeminarAdapter(seminarArrayList)
        recyclerView.adapter = adapterSeminar

        binding.ivArrowBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun dataInitialize3() {
        seminarArrayList = arrayListOf<CategoriesSeminarData>()


        titleEvent1 = arrayOf(
            getString(R.string.title_event),
            getString(R.string.title_event),
            getString(R.string.title_event),
            getString(R.string.title_event),
        )

        price1 = arrayOf(
            "Free",
            "Free",
            "Free",
            "Free",
        )

        img1 = arrayOf(
            R.drawable.ic_seminar,
            R.drawable.ic_seminar2,
            R.drawable.ic_seminar,
            R.drawable.ic_seminar2,
        )

//        creatorEvent = arrayOf(
//            "Gatot",
//            "Gatot",
//            "Gatot",
//            "Gatot"
//        )
//
//        location = arrayOf(
//            "Malang",
//            "Malang",
//            "Malang",
//            "Malang"
//        )
//
//        desc = arrayOf(
//            "wkwkwkwkwkwkwkwkwkwkwkw",
//            "wkwkwkwkwkwkwkwkwkwkwkw",
//            "wkwkwkwkwkwkwkwkwkwkwkw",
//            "wkwkwkwkwkwkwkwkwkwkwkw"
//        )
//
//        dateEvent = arrayOf(
//            "21 Agustus 2023",
//            "21 Agustus 2023",
//            "21 Agustus 2023",
//            "21 Agustus 2023",
//        )
//
//        time = arrayOf(
//            "09.00",
//            "09.00",
//            "09.00",
//            "09.00",
//        )
//
//        type = arrayOf(
//            "Offline",
//            "Online",
//            "Offline",
//            "Online",
//        )

        for (i in titleEvent1.indices) {
            val seminar = CategoriesSeminarData(
                img1[i],
                titleEvent1[i],
                price1[i],
//                creatorEvent[i],
//                location[i],
//                desc[i],
//                dateEvent[i],
//                time[i],
//                type[i]
            )
            seminarArrayList.add(seminar)
        }    }

}
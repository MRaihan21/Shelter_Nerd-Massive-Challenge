package com.xet.ui.home.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.adapter.CategoriesJapaneseAdapter
import com.xet.data.CategoriesJapaneseData
import com.xet.databinding.ActivityCategoriesJapaneseBinding

class CategoriesJapanese : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesJapaneseBinding

    private lateinit var japaneseArrayList : ArrayList<CategoriesJapaneseData>
    private lateinit var adapterJapanese: CategoriesJapaneseAdapter
    private lateinit var recyclerView: RecyclerView


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
        setContentView(R.layout.activity_categories_japanese)

        dataInitialize2()

        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = findViewById(R.id.rv_categories_japanese)
        recyclerView.layoutManager = layoutManager2
        recyclerView.setHasFixedSize(true)
        adapterJapanese = CategoriesJapaneseAdapter(japaneseArrayList)
        recyclerView.adapter = adapterJapanese

    }

    private fun dataInitialize2(){

        japaneseArrayList = arrayListOf<CategoriesJapaneseData>()


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
            R.drawable.ic_japanese,
            R.drawable.ic_japanese2,
            R.drawable.ic_japanese,
            R.drawable.ic_japanese2,
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
            val japanese = CategoriesJapaneseData(
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
            japaneseArrayList.add(japanese)
        }

    }

}
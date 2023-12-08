package com.xet.ui.home.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories_seminar)

        dataInitialize3()

        val layoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = findViewById(R.id.rv_categories_seminar)
        recyclerView.layoutManager = layoutManager3
        recyclerView.setHasFixedSize(true)
        adapterSeminar = CategoriesSeminarAdapter(seminarArrayList)
        recyclerView.adapter = adapterSeminar

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

        for (i in titleEvent1.indices) {
            val seminar = CategoriesSeminarData(
                img1[i],
                titleEvent1[i],
                price1[i],
            )
            seminarArrayList.add(seminar)
        }    }

}
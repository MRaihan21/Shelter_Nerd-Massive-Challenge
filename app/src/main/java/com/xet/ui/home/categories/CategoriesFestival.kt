package com.xet.ui.home.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.adapter.CategoriesFestivalAdapter
import com.xet.data.CategoriesFestivalData
import com.xet.databinding.ActivityCategoriesFestivalBinding

class CategoriesFestival : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesFestivalBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var festivalArrayList : ArrayList<CategoriesFestivalData>
    private lateinit var adapterFestival: CategoriesFestivalAdapter

    lateinit var img1: Array<Int>
    lateinit var titleEvent1 : Array<String>
    lateinit var price1 : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories_festival)

        dataInitialize4()

        val layoutManager4 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView =findViewById(R.id.rv_categories_festival)
        recyclerView.layoutManager = layoutManager4
        recyclerView.setHasFixedSize(true)
        adapterFestival = CategoriesFestivalAdapter(festivalArrayList)
        recyclerView.adapter = adapterFestival

    }

    private fun dataInitialize4() {
        festivalArrayList = arrayListOf<CategoriesFestivalData>()


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
            R.drawable.ic_festival,
            R.drawable.ic_festival2,
            R.drawable.ic_festival,
            R.drawable.ic_festival2,
        )

        for (i in titleEvent1.indices) {
            val festival = CategoriesFestivalData(
                img1[i],
                titleEvent1[i],
                price1[i],
            )
            festivalArrayList.add(festival)
        }
    }

}
package com.xet.ui.home

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.xet.ActivityEVentDetail
import com.xet.ActivityEventDetail2
import com.xet.R
import com.xet.adapter.CategoriesAdapter
import com.xet.data.CategoriesEventData
import com.xet.data.ImageSliderData
import com.xet.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapterCategories: CategoriesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventArrayList : ArrayList<CategoriesEventData>


    lateinit var title: Array<String>
    lateinit var seeAll: Array<String>
    lateinit var img1: Array<Int>
    lateinit var img2: Array<Int>
    lateinit var titleEvent1 : Array<String>
    lateinit var titleEvent2 : Array<String>
    lateinit var price1 : Array<String>
    lateinit var price2 : Array<String>
    lateinit var creatorEvent: Array<String>
    lateinit var location: Array<String>
    lateinit var desc: Array<String>
    lateinit var dateEvent: Array<String>
    lateinit var time: Array<String>
    lateinit var type: Array<String>

    private val binding get() = _binding!!
    private lateinit var adapterImageSlider: ImageSlideAdapter
    private val list = ArrayList<ImageSliderData>()
    private lateinit var dots: ArrayList<TextView>
    private lateinit var searchView: SearchView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        list.add(
            ImageSliderData(
                "https://titipjepang.com/wp-content/uploads/2023/05/BLOG-Event-Jejepangan-Juni-2023-JAPSUKI.jpg"
            )
        )
        list.add(
            ImageSliderData(
                "https://tokopresentasi.com/wp-content/uploads/2020/10/Jasa-desain-poster-untuk-event-tokopresentasi.jpg"
            )
        )
        list.add(
            ImageSliderData(
                "https://img.freepik.com/free-psd/gradient-business-design-template_23-2149295971.jpg"
            )
        )
        list.add(
            ImageSliderData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRVr5a2z57VztRMZD0ElQPYUd4jrN5qXtRsQ&usqp=CAU"
            )
        )


        adapterImageSlider = ImageSlideAdapter(list)
        binding.viewPager.adapter = adapterImageSlider
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_categories)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CategoriesAdapter(eventArrayList)
        {
            val intent = Intent(context, ActivityEVentDetail::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }


//        binding.ivImageEvent.setOnClickListener {
//            val intent = Intent(requireContext(), ActivityEventDetail2::class.java)
//            startActivity(intent)
//        }

        binding.apply {
            btnNotif.setOnClickListener {
                moveNotif()
            }
            ivImageEvent.setOnClickListener {
                moveDetailEvent()
            }

        }
    }


    private fun selectedDot(position: Int) {
        for (i in 0 until list.size) {
            if (i == position) {
                dots[i].setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        com.google.android.material.R.color.design_default_color_primary
                    )
                )
            } else {
                dots[i].setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        com.google.android.material.R.color.design_default_color_secondary
                    )
                )
            }
        }
    }

    private fun setIndicator() {
        for (i in 0 until list.size) {
            dots.add(TextView(requireContext()))
            dots[i].text = Html.fromHtml(".", Html.FROM_HTML_MODE_LEGACY).toString()
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun moveNotif(){
        val action = HomeFragmentDirections.actionNavigationHomeToNotfitikasiFragment()
        findNavController().navigate(action)
    }

    private fun moveDetailEvent(){
        val action = HomeFragmentDirections.actionNavigationHomeToDetailEventFragment2()
        findNavController().navigate(action)
    }

    private fun dataInitialize(){

        eventArrayList = arrayListOf<CategoriesEventData>()

        title = arrayOf(
//            getString(R.string.title_musc),
            getString(R.string.title_japanese),
            getString(R.string.title_seminar),
            getString(R.string.title_festival)
        )

        seeAll = arrayOf(
//            getString(R.string.seeAll),
            getString(R.string.seeAll),
            getString(R.string.seeAll),
            getString(R.string.seeAll)
        )

        titleEvent1 = arrayOf(
//            getString(R.string.title_event),
            getString(R.string.title_event),
            getString(R.string.title_event),
            getString(R.string.title_event)
        )

        titleEvent2 = arrayOf(
//            getString(R.string.title_event),
            getString(R.string.title_event),
            getString(R.string.title_event),
            getString(R.string.title_event)
        )

        price1 = arrayOf(
//            "Rp.100.000",
            "Rp.50.000",
            "Free",
            "Free",
        )

        price2 = arrayOf(
//            "Rp.80.000",
            "Rp.120.000",
            "Rp.15.000",
            "Rp.100.000",
        )

        img1 = arrayOf(
//            R.drawable.ic_music1,
            R.drawable.ic_japanese,
            R.drawable.ic_seminar,
            R.drawable.ic_festival,
        )

        img2 = arrayOf(
//            R.drawable.ic_music2,
            R.drawable.ic_japanese2,
            R.drawable.ic_seminar2,
            R.drawable.ic_festival2,
        )

        creatorEvent = arrayOf(
            "Gatot",
            "Gatot",
            "Gatot",
            "Gatot",
        )

        location = arrayOf(
            "Malang",
            "Medan",
            "Pekanbaru",
            "Jakarta",
        )

        desc = arrayOf(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
        )

        dateEvent = arrayOf(
            "01 Januari 2023",
            "02 Januari 2023",
            "03 Januari 2023",
            "04 Januari 2023",
        )

        time = arrayOf(
            "09.00-12.00",
            "09.00-12.00",
            "09.00-12.00",
            "09.00-12.00",
        )

        type = arrayOf(
            "Online",
            "Offline",
            "Online",
            "Offline",
        )



        for (i in title.indices) {
            val event = CategoriesEventData(
                title[i],
                seeAll[i],
                img1[i],
                titleEvent1[i],
                price1[i],
                img2[i],
                titleEvent2[i],
                price2[i],

//                creatorEvent[i],
//                location[i],
//                desc[i],
//                dateEvent[i],
//                time[i],
//                type[i]
                )
            eventArrayList.add(event)
        }
    }
}

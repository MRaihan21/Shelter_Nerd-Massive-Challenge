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
import com.xet.R
import com.xet.adapter.CategoriesFestivalAdapter
import com.xet.adapter.CategoriesJapaneseAdapter
import com.xet.adapter.CategoriesMusicAdapter
import com.xet.adapter.CategoriesSeminarAdapter
import com.xet.data.CategoriesFestivalData
import com.xet.data.CategoriesJapaneseData
import com.xet.data.CategoriesMusicData
import com.xet.data.CategoriesSeminarData
import com.xet.data.ImageSliderData
import com.xet.databinding.FragmentHomeBinding
import com.xet.ui.home.categories.CategoriesFestival
import com.xet.ui.home.categories.CategoriesJapanese
import com.xet.ui.home.categories.CategoriesMusic
import com.xet.ui.home.categories.CategoriesSeminar
import java.time.chrono.JapaneseDate


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var recyclerView: RecyclerView

    private lateinit var musicArrayList : ArrayList<CategoriesMusicData>
    private lateinit var japaneseArrayList : ArrayList<CategoriesJapaneseData>
    private lateinit var seminarArrayList : ArrayList<CategoriesSeminarData>
    private lateinit var festivalArrayList : ArrayList<CategoriesFestivalData>

    private lateinit var adapterMusic: CategoriesMusicAdapter
    private lateinit var adapterJapanese: CategoriesJapaneseAdapter
    private lateinit var adapterSeminar: CategoriesSeminarAdapter
    private lateinit var adapterFestival: CategoriesFestivalAdapter

    lateinit var img1: Array<Int>
    lateinit var titleEvent1 : Array<String>
    lateinit var price1 : Array<String>

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

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_music)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterMusic = CategoriesMusicAdapter(musicArrayList)
        recyclerView.adapter = adapterMusic

        dataInitialize2()

        val layoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_japanese)
        recyclerView.layoutManager = layoutManager2
        recyclerView.setHasFixedSize(true)
        adapterJapanese = CategoriesJapaneseAdapter(japaneseArrayList)
        recyclerView.adapter = adapterJapanese

        dataInitialize3()

        val layoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_seminar)
        recyclerView.layoutManager = layoutManager3
        recyclerView.setHasFixedSize(true)
        adapterSeminar = CategoriesSeminarAdapter(seminarArrayList)
        recyclerView.adapter = adapterSeminar

        dataInitialize4()

        val layoutManager4 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_festival)
        recyclerView.layoutManager = layoutManager4
        recyclerView.setHasFixedSize(true)
        adapterFestival = CategoriesFestivalAdapter(festivalArrayList)
        recyclerView.adapter = adapterFestival


        binding.apply {
            btnNotif.setOnClickListener {
                moveNotif()
            }
            tvSeeAll.setOnClickListener {
                val intent = Intent(requireContext(), CategoriesMusic::class.java)
                startActivity(intent)
            }
            tvSeeAll2.setOnClickListener {
                val intent = Intent(requireContext(), CategoriesJapanese::class.java)
                startActivity(intent)
            }
            tvSeeAll3.setOnClickListener {
                val intent = Intent(requireContext(), CategoriesSeminar::class.java)
                startActivity(intent)
            }
            tvSeeAll4.setOnClickListener {
                val intent = Intent(requireContext(), CategoriesFestival::class.java)
                startActivity(intent)
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

        musicArrayList = arrayListOf<CategoriesMusicData>()


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
            R.drawable.ic_music1,
            R.drawable.ic_music2,
            R.drawable.ic_music1,
            R.drawable.ic_music2,
        )

        for (i in titleEvent1.indices) {
            val event = CategoriesMusicData(
                img1[i],
                titleEvent1[i],
                price1[i],
                )
            musicArrayList.add(event)
        }
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

        for (i in titleEvent1.indices) {
            val japanese = CategoriesJapaneseData(
                img1[i],
                titleEvent1[i],
                price1[i],
            )
            japaneseArrayList.add(japanese)
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

        for (i in titleEvent1.indices) {
            val seminar = CategoriesSeminarData(
                img1[i],
                titleEvent1[i],
                price1[i],
            )
            seminarArrayList.add(seminar)
        }    }


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

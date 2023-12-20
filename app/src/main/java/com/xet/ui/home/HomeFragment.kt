package com.xet.ui.home

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.xet.Activity.All.ActivityAllFestival
import com.xet.Activity.All.ActivityAllJapanese
import com.xet.Activity.All.ActivityAllMusic
import com.xet.Activity.All.ActivityAllSeminar
import com.xet.Activity.Detail.ActivityFestivalDetail
import com.xet.Activity.Detail.ActivityJapaneseDetail
import com.xet.Activity.Detail.ActivityMusicDetail
import com.xet.Activity.Detail.ActivitySeminarDetail
import com.xet.Adapter.FestivalAdapter
import com.xet.Adapter.ImageSlideAdapter
import com.xet.Adapter.JapaneseAdapter
import com.xet.Adapter.MusicAdapter
import com.xet.Adapter.SeminarAdapter
import com.xet.Models.FestivalModel
import com.xet.Models.ImageSlideModel
import com.xet.Models.JapaneseModel
import com.xet.Models.MusicModel
import com.xet.Models.SeminarModel
import com.xet.R
import com.xet.databinding.FragmentHomeBinding
import com.xet.ui.home.other.NotifikasiActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var musicList: ArrayList<MusicModel>
    private lateinit var japaneseList: ArrayList<JapaneseModel>
    private lateinit var seminarList: ArrayList<SeminarModel>
    private lateinit var festivalList: ArrayList<FestivalModel>

    private  val imageSlideList = ArrayList<ImageSlideModel>()

    private lateinit var adapterImageSlide: ImageSlideAdapter

    private lateinit var dots: ArrayList<TextView>
    private lateinit var searchView: SearchView

    private lateinit var recyclerView: RecyclerView




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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        imageSlideList.add(
            ImageSlideModel(
                "https://titipjepang.com/wp-content/uploads/2023/05/BLOG-Event-Jejepangan-Juni-2023-JAPSUKI.jpg"
            )
        )

        imageSlideList.add(
            ImageSlideModel(
                "https://tokopresentasi.com/wp-content/uploads/2020/10/Jasa-desain-poster-untuk-event-tokopresentasi.jpg"
            )
        )

        imageSlideList.add(
            ImageSlideModel(
                "https://img.freepik.com/free-psd/gradient-business-design-template_23-2149295971.jpg"
            )
        )

        imageSlideList.add(
            ImageSlideModel(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRVr5a2z57VztRMZD0ElQPYUd4jrN5qXtRsQ&usqp=CAU"
            )
        )

        adapterImageSlide = ImageSlideAdapter(imageSlideList)
        binding.viewPager.adapter = adapterImageSlide
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

        //music
        dataInitialize()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_music)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MusicAdapter(musicList){
            val intent = Intent(context, ActivityMusicDetail::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        //japanese
        dataInitialize2()
        val layoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_japanese)
        recyclerView.layoutManager = layoutManager2
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = JapaneseAdapter(japaneseList){
            val intent2 = Intent(context, ActivityJapaneseDetail::class.java)
            intent2.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent2)
        }

        //seminar
        dataInitialize3()
        val layoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_seminar)
        recyclerView.layoutManager = layoutManager3
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SeminarAdapter(seminarList){
            val intent3 = Intent(context, ActivitySeminarDetail::class.java)
            intent3.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent3)
        }

        //festival
        dataInitialize4()
        val layoutManager4 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.rv_categories_festival)
        recyclerView.layoutManager = layoutManager4
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = FestivalAdapter(festivalList){
            val intent4 = Intent(context, ActivityFestivalDetail::class.java)
            intent4.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent4)
        }

        binding.apply {
            tvSeeAll1.setOnClickListener {
                val intent = Intent(requireContext(), ActivityAllMusic::class.java)
                startActivity(intent)
            }
            tvSeeAll2.setOnClickListener {
                val intent = Intent(requireContext(), ActivityAllJapanese::class.java)
                startActivity(intent)
            }
            tvSeeAll3.setOnClickListener {
                val intent = Intent(requireContext(), ActivityAllSeminar::class.java)
                startActivity(intent)
            }
            tvSeeAll4.setOnClickListener {
                val intent = Intent(requireContext(), ActivityAllFestival::class.java)
                startActivity(intent)
            }
            btnNotif.setOnClickListener {
                val intent = Intent(requireContext(), NotifikasiActivity::class.java)
                startActivity(intent)
            }
        }
    }


    private fun selectedDot(position: Int) {
        for (i in 0 until imageSlideList.size) {
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
        for (i in 0 until imageSlideList.size) {
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



        for (i in image.indices){
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

    private fun dataInitialize2() {
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

    private fun dataInitialize3() {
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


    private fun dataInitialize4() {
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


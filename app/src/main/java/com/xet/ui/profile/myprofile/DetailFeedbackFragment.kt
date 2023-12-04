package com.xet.ui.profile.myprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.adapter.FeedbackAdapter
import com.xet.data.FeedbackData
import com.xet.databinding.FragmentDetailFeedbackBinding


class DetailFeedbackFragment : Fragment() {

    private var _binding: FragmentDetailFeedbackBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterDetailFeedback: FeedbackAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var feedbackDataArrayList: ArrayList<FeedbackData>

    lateinit var date: Array<String>
    lateinit var username: Array<String>
    lateinit var comment: Array<String>
    lateinit var ratting: Array<Float>
    lateinit var profileImg: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailFeedbackBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_feedback)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterDetailFeedback = FeedbackAdapter(feedbackDataArrayList)
        recyclerView.adapter = adapterDetailFeedback

        binding.ivArrowBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

    }

    private fun dataInitialize() {

        feedbackDataArrayList = arrayListOf<FeedbackData>()

        date = arrayOf(
            getString(R.string.date_1),
            getString(R.string.date_2)
        )

        username = arrayOf(
            getString(R.string.username1),
            getString(R.string.username2)
        )

        profileImg = arrayOf(
            R.drawable.profile,
            R.drawable.profile,
        )

        comment = arrayOf(
            getString(R.string.comment1),
            getString(R.string.comment2)
        )

        ratting = arrayOf(
            getString(R.string.ratting1).toFloat(),
            getString(R.string.ratting2).toFloat()
        )

        for (i in date.indices){
            val feedbackData = FeedbackData(
                date[i],
                username[i],
                profileImg[i],
                ratting[i],
                comment[i]
            )
            feedbackDataArrayList.add(feedbackData)
        }
    }
}
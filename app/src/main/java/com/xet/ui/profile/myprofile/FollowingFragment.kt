package com.xet.ui.profile.myprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.adapter.CategoriesAdapter
import com.xet.adapter.FollowingAdapter
import com.xet.data.FollowingData
import com.xet.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    private var _binding : FragmentFollowingBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterFollowing: FollowingAdapter
    private lateinit var recyclerView : RecyclerView
    private lateinit var followingList: ArrayList<FollowingData>

    lateinit var profileFollowing : Array<Int>
    lateinit var profileName: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_following)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterFollowing = FollowingAdapter(followingList)
        recyclerView.adapter = adapterFollowing

        binding.ivArrowBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

    }

    private fun dataInitialize() {
        followingList = arrayListOf<FollowingData>()

        profileFollowing = arrayOf(
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile
        )

        profileName = arrayOf(
            "Gatot",
            "Gatot",
            "Gatot",
            "Gatot",
        )

        for (i in profileFollowing.indices){
            val following = FollowingData(
                profileFollowing[i],
                profileName[i]
            )
            followingList.add(following)
        }

    }

}
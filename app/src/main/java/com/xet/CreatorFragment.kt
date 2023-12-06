package com.xet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.adapter.CreatorAdapter
import com.xet.data.CreatorData
import com.xet.databinding.FragmentCreatorBinding


class CreatorFragment : Fragment() {

    private var _binding: FragmentCreatorBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var creatorList: ArrayList<CreatorData>
    private lateinit var adapterCreator: CreatorAdapter

    lateinit var imageCreator : Array<Int>
//    lateinit var imageCreator2 : Array<Int>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_crator)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterCreator = CreatorAdapter(creatorList)
        recyclerView.adapter = adapterCreator

        binding.apply {
            btnFollow.setOnClickListener {
                moveFollowing()
            }
            binding.ivArrowBack.setOnClickListener{
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }

    private fun moveFollowing(){
        val action = CreatorFragmentDirections.actionCreatorFragmentToFollowingFragment()
        findNavController().navigate(action)
        }

    private fun moveMessage(){
        val action = CreatorFragmentDirections.actionCreatorFragmentToFollowingFragment()
        findNavController().navigate(action)
    }

    private fun dataInitialize(){

        creatorList = arrayListOf<CreatorData>()

        imageCreator = arrayOf(
            R.drawable.ic_music1
        )
//        imageCreator2 = arrayOf(
//            R.drawable.ic_music2
//        )

        for (i in imageCreator.indices){
            val creator = CreatorData(
                imageCreator[i],
//                imageCreator2[i]
            )
            creatorList.add(creator)
        }
    }
}
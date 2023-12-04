package com.xet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.xet.databinding.FragmentCreatorBinding


class CreatorFragment : Fragment() {

    private var _binding: FragmentCreatorBinding? = null
    private val binding get() = _binding!!


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
        binding.apply {
            btnFollow.setOnClickListener {
                moveFollowing()
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

}
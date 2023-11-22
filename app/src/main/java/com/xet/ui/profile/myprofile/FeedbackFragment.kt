package com.xet.ui.profile.myprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.xet.R
import com.xet.databinding.FragmentFeedbackBinding
import com.xet.ui.profile.ProfileFragmentDirections

class FeedbackFragment : Fragment() {

    private var _binding : FragmentFeedbackBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedbackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSubmit.setOnClickListener {
                moveSubmit()
            }
        }

    }

    fun moveSubmit(){
        val action = FeedbackFragmentDirections.actionFeedbackFragmentToFeedbackDoneFragment()
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
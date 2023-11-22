package com.xet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.xet.databinding.FragmentDetailEventBinding

class DetailEventFragment : Fragment() {

    private var _binding: FragmentDetailEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        return inflater.inflate(R.layout.fragment_detail_event, container, false)

        _binding = FragmentDetailEventBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnBuyNow.setOnClickListener {
                movePayment()
            }
            btnLocation.setOnClickListener {
                moveLocation()
            }
            creator.setOnClickListener {
                moveCreator()
            }
        }
    }


    private fun movePayment(){
        val action = DetailEventFragmentDirections.actionDetailEventFragmentToPaymentFragment()
        findNavController().navigate(action)
    }

    private fun moveLocation(){
        val action = DetailEventFragmentDirections.actionDetailEventFragmentToLocationFragment()
        findNavController().navigate(action)
    }

    private fun moveCreator(){
        val action = DetailEventFragmentDirections.actionDetailEventFragmentToCreatorFragment()
        findNavController().navigate(action)
    }

}
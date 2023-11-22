package com.xet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.xet.R
import com.xet.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment(){

    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnPay.setOnClickListener {
                moveQrCode()
            }
        }
    }

    private fun moveQrCode(){
        val action = PaymentFragmentDirections.actionPaymentFragmentToQrCodeFragment()
        findNavController().navigate(action)
    }
}
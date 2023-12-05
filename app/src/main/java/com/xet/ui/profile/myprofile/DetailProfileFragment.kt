package com.xet.ui.profile.myprofile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xet.R
import com.xet.databinding.FragmentDetailProfileBinding
import com.xet.databinding.FragmentNotfitikasiBinding

class DetailProfileFragment : Fragment() {

    private var _binding : FragmentDetailProfileBinding? = null
    private val binding get() = _binding!!

    private var selectedImageUrl: Uri? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailProfileBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivArrowBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        binding.imageView2.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val url = data?.data
            if (url != null) {
                binding.imageView2.setImageURI(url)

                selectedImageUrl = url
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
package com.xet.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.xet.Activity.Login.ChangePasswordActivity
import com.xet.Activity.Login.LoginActivity
import com.xet.Models.FeedbackModel
import com.xet.Models.TransactionHistoryModel
import com.xet.databinding.FragmentProfileBinding
import com.xet.ui.profile.DetailProfile.DetailProfile
import com.xet.ui.profile.DetailProfile.FeedbackActivity
import com.xet.ui.profile.DetailProfile.TransactionHistory

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            editeProfile.setOnClickListener {
                val intent = Intent(requireContext(), DetailProfile::class.java)
                startActivity(intent)
            }
            btnTransaction.setOnClickListener {
                val intent = Intent(requireContext(), TransactionHistory::class.java)
                startActivity(intent)
            }
            btnFeedback.setOnClickListener {
                val intent = Intent(requireContext(), FeedbackActivity::class.java)
                startActivity(intent)
            }
            btnChangePassword.setOnClickListener {
                val intent = Intent(requireContext(), ChangePasswordActivity::class.java)
                startActivity(intent)
            }
            btnLogout.setOnClickListener {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)
            }


        }

    }

}
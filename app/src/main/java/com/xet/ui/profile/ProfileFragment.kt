package com.xet.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.findNavController
import com.xet.ChangePasswordActivity
import com.xet.ForgotPasswordActivity
import com.xet.LoginActivity
import com.xet.databinding.FragmentProfileBinding
import com.xet.ui.profile.myprofile.ChangePasswordFragment
import com.xet.ui.profile.myprofile.Following
import com.xet.ui.profile.myprofile.FollowingFragment

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
//            btnFollowing.setOnClickListener {
//                moveFollowing()
//            }
            btnTransaction.setOnClickListener {
                moveTransactionHistory()
            }
            btnFeedback.setOnClickListener {
                moveDetailFeedback()
//                moveFeedback()
            }
//            btnChangePassword.setOnClickListener{
//                moveChangePassword()
//            }
            btnLogout.setOnClickListener {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)
            }
            btnChangePassword.setOnClickListener {
                val intent = Intent(requireContext(), ChangePasswordActivity::class.java)
                startActivity(intent)
            }
            editeProfile.setOnClickListener {
                moveEditProfile()
            }
//            binding.btnFollowing.setOnClickListener {
//                val intent = Intent(requireContext(), Following::class.java)
//                startActivity(intent)
//            }
        }
    }

    private fun moveFollowing(){
        val action = ProfileFragmentDirections.actionNavigationProfileToFollowingFragment()
        findNavController().navigate(action)
    }

    private fun moveTransactionHistory(){
        val action = ProfileFragmentDirections.actionNavigationProfileToTransactionHistoryFragment()
        findNavController().navigate(action)
    }




    private fun moveChangePassword() {
        val action = ProfileFragmentDirections.actionNavigationProfileToChangePasswordFragment()
        findNavController().navigate(action)
    }

    private fun moveEditProfile(){
        val action = ProfileFragmentDirections.actionNavigationProfileToDetailProfileFragment()
        findNavController().navigate(action)
    }
    private fun moveDetailFeedback(){
        val action = ProfileFragmentDirections.actionNavigationProfileToDetailFeedbackFragment()
        findNavController().navigate(action)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
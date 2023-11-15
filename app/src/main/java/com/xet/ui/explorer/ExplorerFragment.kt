package com.xet.ui.explorer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.xet.databinding.FragmentExplorerBinding

class ExplorerFragment : Fragment() {

    private var _binding: FragmentExplorerBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val explorerViewModel =
            ViewModelProvider(this).get(ExplorerViewModel::class.java)

        _binding = FragmentExplorerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val texView: TextView = binding.textFollower
        explorerViewModel.text.observe(viewLifecycleOwner){
            texView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




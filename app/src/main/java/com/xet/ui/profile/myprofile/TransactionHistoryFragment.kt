package com.xet.ui.profile.myprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.adapter.TransactionHistoryAdapter
import com.xet.data.TransactionHistoryData
import com.xet.databinding.FragmentTransactionBinding

class TransactionHistoryFragment : Fragment() {

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterTransactionHistory: TransactionHistoryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var transactionHistoryList: ArrayList<TransactionHistoryData>

    lateinit var dateTransactionHistory: Array<String>
    lateinit var titleTransactionHistory: Array<String>
    lateinit var dateDetailTransactionHistory: Array<String>
    lateinit var orderCode: Array<String>
    lateinit var locationTransactionHistory: Array<String>
    lateinit var priceTransactionHistory: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_transcation_history)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterTransactionHistory = TransactionHistoryAdapter(transactionHistoryList)
        recyclerView.adapter = adapterTransactionHistory

        binding.ivArrowBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun dataInitialize() {

        transactionHistoryList = arrayListOf<TransactionHistoryData>()

        dateTransactionHistory = arrayOf(
            "17 Agustus 2023",
            "17 Agustus 2023"
        )

        orderCode = arrayOf(
            "CODE123",
            "CODE123"
        )

        titleTransactionHistory = arrayOf(
            "Event",
            "Event"
        )

        dateDetailTransactionHistory = arrayOf(
            "Wednesday, 16 August 2023",
            "Wednesday, 16 August 2023",
        )

        locationTransactionHistory = arrayOf(
            "Malang",
            "Malang"
        )

        priceTransactionHistory = arrayOf(
            "RP.100.000",
            "RP.100.000"
        )

        for (i in dateTransactionHistory.indices){
            val transactionHistory = TransactionHistoryData(
                dateTransactionHistory[i],
                orderCode[i],
                titleTransactionHistory[i],
                dateDetailTransactionHistory[i],
                locationTransactionHistory[i],
                priceTransactionHistory[i]
            )
            transactionHistoryList.add(transactionHistory)
        }

    }

}
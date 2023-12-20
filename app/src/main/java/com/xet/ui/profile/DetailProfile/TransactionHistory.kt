package com.xet.ui.profile.DetailProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xet.Adapter.FeedbackAdapter
import com.xet.Adapter.TransactionHistoryAdapter
import com.xet.Models.FeedbackModel
import com.xet.Models.TransactionHistoryModel
import com.xet.R
import com.xet.databinding.ActivityFestivalDetailBinding
import com.xet.databinding.ActivityTransactionHistoryBinding

class TransactionHistory : AppCompatActivity() {

    private lateinit var binding : ActivityTransactionHistoryBinding

    private lateinit var transactionList: ArrayList<TransactionHistoryModel>

    lateinit var date: Array<String>
    lateinit var orderCode: Array<String>
    lateinit var title: Array<String>
    lateinit var dateDetail: Array<String>
    lateinit var location: Array<String>
    lateinit var price: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_history)

        binding = ActivityTransactionHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowBack.setOnClickListener {
            onBackPressed()
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, false)
        val recyclerView: RecyclerView = findViewById(R.id.rv_transcation_history)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = TransactionHistoryAdapter(transactionList){

        }

    }

    private fun dataInitialize() {
        transactionList = arrayListOf<TransactionHistoryModel>()

        date = arrayOf(
            "21 September 2023",
            "21 April 2023",
        )
        orderCode = arrayOf(
            "DJ34JW44",
            "353KJNLS",
        )
        title = arrayOf(
            "Hellocalize Festival",
            "seminar Pendidikan",
        )
        dateDetail = arrayOf(
           "Kamis, 21 September 2023",
           "Senin, 21 April 2023",
        )
        location = arrayOf(
            "Malang",
            "Bandung",
        )
        price = arrayOf(
            "Rp.200.000",
            "Rp.50.000",
        )

        for (i in date.indices){
            val transaction = TransactionHistoryModel(
                date[i],
                orderCode[i],
                title[i],
                dateDetail[i],
                location[i],
                price[i]
            )
            transactionList.add(transaction)
        }

    }

}
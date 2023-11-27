package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.TransactionHistoryData

class TransactionHistoryAdapter(private val transactionHistoryList: ArrayList<TransactionHistoryData>):
    RecyclerView.Adapter<TransactionHistoryAdapter.MyViewHolder>(){

    class MyViewHolder(itemVIew: View):  RecyclerView.ViewHolder(itemVIew){
       val dateTitle = itemVIew.findViewById<TextView>(R.id.tv_date_history_transaction)
       val titleTransactionHistory = itemVIew.findViewById<TextView>(R.id.tv_title_transaction_history)
       val orderCode = itemVIew.findViewById<TextView>(R.id.tv_order_code)
       val dateDetail = itemVIew.findViewById<TextView>(R.id.tv_date_transaction_history)
       val location = itemVIew.findViewById<TextView>(R.id.tv_location_transaction_history)
       val price = itemVIew.findViewById<TextView>(R.id.iv_price_transaction_history)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemVIew = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction_history, parent, false)
        return MyViewHolder(itemVIew)
    }

    override fun getItemCount(): Int {
       return transactionHistoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = transactionHistoryList[position]
        holder.dateTitle.text = item.date
        holder.titleTransactionHistory.text = item.title
        holder.orderCode.text = item.orderCode
        holder.dateDetail.text = item.dateDetail
        holder.location.text = item.location
        holder.price.text = item.price
    }


}
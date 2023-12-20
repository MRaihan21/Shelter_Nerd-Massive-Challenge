package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.TransactionHistoryModel
import com.xet.R

class TransactionHistoryAdapter(
    private val transactionList: List<TransactionHistoryModel>,
    val listener: (TransactionHistoryModel) -> Unit)
    : RecyclerView.Adapter<TransactionHistoryAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.tv_date_history_transaction)
        val orderCode: TextView = view.findViewById(R.id.tv_order_code)
        val title: TextView = view.findViewById(R.id.tv_title_transaction_history)
        val dateDetail: TextView = view.findViewById(R.id.tv_date_detail_transaction_history)
        val location: TextView = view.findViewById(R.id.tv_location_transaction_history)
        val price: TextView = view.findViewById(R.id.iv_price_transaction_history)

        fun bindView(transaction: TransactionHistoryModel, listener: (TransactionHistoryModel) -> Unit){
            date.text = transaction.date
            orderCode.text = transaction.orderCode
            title.text = transaction.title
            dateDetail.text = transaction.dateDetail
            location.text = transaction.location
            price.text = transaction.price
            itemView.setOnClickListener {
                listener(transaction)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction_history, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = transactionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(transactionList[position], listener)

        val transaction = transactionList[position]
        holder.date.text = transaction.date
        holder.orderCode.text = transaction.orderCode
        holder.title.text = transaction.title
        holder.dateDetail.text = transaction.dateDetail
        holder.location.text = transaction.location
        holder.price.text = transaction.price
        itemCount

    }

}

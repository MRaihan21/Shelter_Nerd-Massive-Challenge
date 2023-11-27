package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.TicketData

class TicketAdapter(private val ticketDataList: ArrayList<TicketData>):
    RecyclerView.Adapter<TicketAdapter.MyViewHolder>(){

    class MyViewHolder(itemVIew: View):  RecyclerView.ViewHolder(itemVIew){
        val imageTicket = itemVIew.findViewById<ImageView>(R.id.iv_image_ticket1)
        val imageTicket2 = itemVIew.findViewById<ImageView>(R.id.iv_image_ticket2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemVIew = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return MyViewHolder(itemVIew)
    }

    override fun getItemCount(): Int {
        return ticketDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = ticketDataList[position]
        holder.imageTicket.setImageResource(item.imgTicket)
        holder.imageTicket2.setImageResource(item.imgTicket2)
    }


}
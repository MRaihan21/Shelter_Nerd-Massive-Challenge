package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.TicketModel
import com.xet.R

class TicketAdapter  (
    private var ticketList: List<TicketModel>,
    var listener: (TicketModel) -> Unit)
    : RecyclerView.Adapter<TicketAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_myticket)

        fun bindView(ticket: TicketModel, listener: (TicketModel) -> Unit){
            img.setImageResource(ticket.img)
            itemView.setOnClickListener {
                listener(ticket)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = ticketList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(ticketList[position], listener)

        val ticket = ticketList[position]
        holder.img.setImageResource(ticket.img)
        itemCount

    }
}
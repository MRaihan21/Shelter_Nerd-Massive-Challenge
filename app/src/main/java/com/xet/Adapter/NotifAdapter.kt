package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.NotifModel
import com.xet.R

class NotifAdapter  (
    private var notifList: List<NotifModel>,
    var listener: (NotifModel) -> Unit)
    : RecyclerView.Adapter<NotifAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_profile_notif)
        val message: TextView = view.findViewById(R.id.tv_message_notif)
        val date: TextView = view.findViewById(R.id.tv_date_notif)

        fun bindView(notif: NotifModel, listener: (NotifModel) -> Unit){
            img.setImageResource(notif.img)
            message.text = notif.message
            date.text = notif.date
            itemView.setOnClickListener {
                listener(notif)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_notifikasi, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = notifList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(notifList[position], listener)

        val notif = notifList[position]
        holder.img.setImageResource(notif.img)
        holder.message.text = notif.message
        holder.date.text = notif.date
        itemCount

    }
}
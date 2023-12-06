package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.CreatorData

class CreatorAdapter(private val creatorList: ArrayList<CreatorData>)
    : RecyclerView.Adapter<CreatorAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageCrator = itemView.findViewById<ImageView>(R.id.iv_image_ticket1)
//        val imageCrator2 = itemView.findViewById<ImageView>(R.id.iv_image_ticket2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return creatorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curentItem = creatorList[position]
        holder.imageCrator.setImageResource(curentItem.imageCreator)
//        holder.imageCrator2.setImageResource(curentItem.imageCreator2)
    }


}
package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.CategoriesSeminarData

class CategoriesSeminarAdapter(private val seminarList: ArrayList<CategoriesSeminarData>)
    : RecyclerView.Adapter<CategoriesSeminarAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img1 = itemView.findViewById<ImageView>(R.id.iv_image_event_seminar)
        val titleEvent1 = itemView.findViewById<TextView>(R.id.tv_title_seminar1)
        val price1 = itemView.findViewById<TextView>(R.id.tv_price_seminar1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_seminar, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return seminarList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = seminarList[position]

        holder.titleEvent1.text = currentItem.titleEvent1
        holder.img1.setImageResource(currentItem.imageCategories1)
        holder.price1.text = currentItem.price1
    }
}
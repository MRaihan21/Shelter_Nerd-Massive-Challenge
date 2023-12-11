package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.CategoriesFestivalData
import com.xet.data.CategoriesSeminarData

class CategoriesFestivalAdapter (private val festivalList: ArrayList<CategoriesFestivalData>)
: RecyclerView.Adapter<CategoriesFestivalAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img1 = itemView.findViewById<ImageView>(R.id.iv_image_event)
        val titleEvent1 = itemView.findViewById<TextView>(R.id.tv_title_event)
        val price1 = itemView.findViewById<TextView>(R.id.tv_price_event)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_event, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return festivalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = festivalList[position]

        holder.titleEvent1.text = currentItem.titleEvent1
        holder.img1.setImageResource(currentItem.imageCategories1)
        holder.price1.text = currentItem.price1
    }
}
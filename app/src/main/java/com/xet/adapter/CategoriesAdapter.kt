package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.CategoriesEventData

class CategoriesAdapter(private val eventList: ArrayList<CategoriesEventData>):
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleEventCategories = itemView.findViewById<TextView>(R.id.title_categories)
        val textSeeAll = itemView.findViewById<TextView>(R.id.tv_see_all)
        val titleEvent1 = itemView.findViewById<TextView>(R.id.tv_title1)
        val img1 = itemView.findViewById<ImageView>(R.id.iv_image_event)
        val price1 = itemView.findViewById<TextView>(R.id.tv_price1)
        val titleEvent2 = itemView.findViewById<TextView>(R.id.tv_title2)
        val img2 = itemView.findViewById<ImageView>(R.id.iv_image_event2)
        val price2 = itemView.findViewById<TextView>(R.id.tv_price2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_event, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return eventList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = eventList[position]
        holder.titleEventCategories.text = currentItem.title
        holder.textSeeAll.text = currentItem.seeAll
        holder.titleEvent1.text = currentItem.titleEvent1
        holder.titleEvent2.text = currentItem.titleEvent2
        holder.img1.setImageResource(currentItem.imageCategories1)
        holder.img2.setImageResource(currentItem.imageCategories2)
        holder.price1.text = currentItem.price1
        holder.price2.text = currentItem.price2
    }


}



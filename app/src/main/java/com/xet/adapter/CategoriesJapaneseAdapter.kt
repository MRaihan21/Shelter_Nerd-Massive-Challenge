package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.CategoriesJapaneseData

class CategoriesJapaneseAdapter(private val japaneseList: ArrayList<CategoriesJapaneseData>)
    : RecyclerView.Adapter<CategoriesJapaneseAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img1 = itemView.findViewById<ImageView>(R.id.iv_image_event_japanese)
        val titleEvent1 = itemView.findViewById<TextView>(R.id.tv_title_japanese1)
        val price1 = itemView.findViewById<TextView>(R.id.tv_price_japanese1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_japanese, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return japaneseList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = japaneseList[position]

        holder.titleEvent1.text = currentItem.titleEvent2
        holder.img1.setImageResource(currentItem.imageCategories2)
        holder.price1.text = currentItem.price2
    }
}
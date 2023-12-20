package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.FestivalModel
import com.xet.R

class FestivalAdapter  (
    private var festivalList: List<FestivalModel>,
    var listener: (FestivalModel) -> Unit)
    : RecyclerView.Adapter<FestivalAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_image_event)
        val title: TextView = view.findViewById(R.id.tv_title_event)
        val price: TextView = view.findViewById(R.id.tv_price_event)

        fun bindView(festival: FestivalModel, listener: (FestivalModel) -> Unit){
            img.setImageResource(festival.img)
            title.text = festival.title
            price.text = festival.price
            itemView.setOnClickListener {
                listener(festival)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = festivalList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(festivalList[position], listener)

        val festival = festivalList[position]
        holder.img.setImageResource(festival.img)
        holder.title.text = festival.title
        holder.price.text = festival.price
        itemCount

    }
}
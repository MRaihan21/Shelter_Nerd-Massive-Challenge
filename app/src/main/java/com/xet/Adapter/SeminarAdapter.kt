package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.SeminarModel
import com.xet.R

class SeminarAdapter  (
    private var seminarList: List<SeminarModel>,
    var listener: (SeminarModel) -> Unit)
    : RecyclerView.Adapter<SeminarAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_image_event)
        val title: TextView = view.findViewById(R.id.tv_title_event)
        val price: TextView = view.findViewById(R.id.tv_price_event)

        fun bindView(seminar: SeminarModel, listener: (SeminarModel) -> Unit){
            img.setImageResource(seminar.img)
            title.text = seminar.title
            price.text = seminar.price
            itemView.setOnClickListener {
                listener(seminar)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = seminarList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(seminarList[position], listener)

        val seminar = seminarList[position]
        holder.img.setImageResource(seminar.img)
        holder.title.text = seminar.title
        holder.price.text = seminar.price
        itemCount

    }
}
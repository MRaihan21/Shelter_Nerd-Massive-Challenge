package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.JapaneseModel
import com.xet.Models.MusicModel
import com.xet.R

class JapaneseAdapter (
    private var japaneseList: List<JapaneseModel>,
    var listener: (JapaneseModel) -> Unit)
    : RecyclerView.Adapter<JapaneseAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_image_event)
        val title: TextView = view.findViewById(R.id.tv_title_event)
        val price: TextView = view.findViewById(R.id.tv_price_event)

        fun bindView(japanese: JapaneseModel, listener: (JapaneseModel) -> Unit){
            img.setImageResource(japanese.img)
            title.text = japanese.title
            price.text = japanese.price
            itemView.setOnClickListener {
                listener(japanese)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = japaneseList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(japaneseList[position], listener)

        val music = japaneseList[position]
        holder.img.setImageResource(music.img)
        holder.title.text = music.title
        holder.price.text = music.price
        itemCount

    }
}
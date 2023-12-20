package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.MusicModel
import com.xet.R

class MusicAdapter(
    private var musicList: List<MusicModel>,
    var listener: (MusicModel) -> Unit)
: RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_image_event)
        val title: TextView = view.findViewById(R.id.tv_title_event)
        val price: TextView = view.findViewById(R.id.tv_price_event)

        fun bindView(music: MusicModel, listener: (MusicModel) -> Unit){
            img.setImageResource(music.img)
            title.text = music.title
            price.text = music.price
            itemView.setOnClickListener {
                listener(music)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_categories_event, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = musicList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(musicList[position], listener)

        val music = musicList[position]
        holder.img.setImageResource(music.img)
        holder.title.text = music.title
        holder.price.text = music.price
        itemCount

    }
}
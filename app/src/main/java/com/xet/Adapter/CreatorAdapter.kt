package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.CreatorModel
import com.xet.R

class CreatorAdapter (
    private var creatorList: List<CreatorModel>,
    var listener: (CreatorModel) -> Unit)
    : RecyclerView.Adapter<CreatorAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_image_categories_detail)
        val title: TextView = view.findViewById(R.id.tv_title_categorie_detail)
        val desch: TextView = view.findViewById(R.id.tv_desc_categories_detail)

        fun bindView(creator: CreatorModel, listener: (CreatorModel) -> Unit){
            img.setImageResource(creator.img)
            title.text = creator.title
            desch.text = creator.desc
            itemView.setOnClickListener {
                listener(creator)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_creator_detail, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = creatorList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(creatorList[position], listener)

        val creator = creatorList[position]
        holder.img.setImageResource(creator.img)
        holder.title.text = creator.title
        holder.desch.text = creator.desc
        itemCount

    }
}
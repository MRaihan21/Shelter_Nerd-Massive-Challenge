package com.xet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xet.databinding.ItemSlideBinding

class ImageSlideAdapter(private val item: List<ImageData>) : RecyclerView.Adapter<ImageSlideAdapter.ImageViewHolder>(){
    inner class ImageViewHolder(itemVIew: ItemSlideBinding) : RecyclerView.ViewHolder(itemVIew.root){
        private val binding = itemVIew
        fun bind(data: ImageData){
            with(binding){
                Glide.with(itemView)
                    .load(data.imageUrl)
                    .into(ivSlider)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(item[position])
    }

}
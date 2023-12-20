package com.xet.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xet.Models.ImageSlideModel
import com.xet.databinding.ItemImageSliderBinding

class ImageSlideAdapter (private val item: List<ImageSlideModel>) : RecyclerView.Adapter<ImageSlideAdapter.ImageViewHolder>(){
    inner class ImageViewHolder(itemVIew: ItemImageSliderBinding) : RecyclerView.ViewHolder(itemVIew.root){
        private val binding = itemVIew
        fun bind(data: ImageSlideModel){
            with(binding){
                Glide.with(itemView)
                    .load(data.imgUrl)
                    .into(ivSlider)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemImageSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(item[position])
    }

}
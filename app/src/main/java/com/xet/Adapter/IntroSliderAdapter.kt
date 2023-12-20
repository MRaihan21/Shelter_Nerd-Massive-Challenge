package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.IntroSliderModel
import com.xet.R

class IntroSliderAdapter(private val introSlider: List<IntroSliderModel>)
    : RecyclerView.Adapter<IntroSliderAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val img = view.findViewById<ImageView>(R.id.iv_image_intro1)
        private val title = view.findViewById<TextView>(R.id.tv_tite_intro)
        private val desc = view.findViewById<TextView>(R.id.tv_desc_intro)

        fun bind(introSlider : IntroSliderModel) {
            img.setImageResource(introSlider.img)
            title.text = introSlider.title
            desc.text = introSlider.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.slide_item_container, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return introSlider.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(introSlider[position])
    }


}
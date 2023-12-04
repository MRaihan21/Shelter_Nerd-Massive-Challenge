package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.FollowingData

class FollowingAdapter(private val followingDataList: ArrayList<FollowingData>):
    RecyclerView.Adapter<FollowingAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.iv_creator_following)
        val nameFollowing = itemView.findViewById<TextView>(R.id.tv_name_following)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_following, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return followingDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = followingDataList[position]
        holder.profile.setImageResource(item.picture)
        holder.nameFollowing.text = item.name
    }

}
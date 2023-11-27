package com.xet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.R
import com.xet.data.FeedbackData
import org.w3c.dom.Text

class FeedbackAdapter(private val feedbackDataList: ArrayList<FeedbackData>):
    RecyclerView.Adapter<FeedbackAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tanggal = itemView.findViewById<TextView>(R.id.tv_date_feedback)
        val imageProfile = itemView.findViewById<ImageView>(R.id.iv_profile_feedback)
        val username = itemView.findViewById<TextView>(R.id.tv_username_feedback)
        val ratting = itemView.findViewById<RatingBar>(R.id.rb_rattingbar)
        val comment = itemView.findViewById<TextView>(R.id.tv_comment_feedback)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_feedback, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return feedbackDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = feedbackDataList[position]
        holder.tanggal.text = item.date
        holder.username.text = item.name
        holder.imageProfile.setImageResource(item.image)
        holder.comment.text = item.comment
        holder.ratting.rating = item.rating.toFloat()

    }
}
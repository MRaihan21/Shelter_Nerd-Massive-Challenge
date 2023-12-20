package com.xet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xet.Models.FeedbackModel
import com.xet.Models.MusicModel
import com.xet.R

class FeedbackAdapter (
    private var feedbackList: List<FeedbackModel>,
    var listener: (FeedbackModel) -> Unit)
    : RecyclerView.Adapter<FeedbackAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.tv_date_feedback)
        val name: TextView = view.findViewById(R.id.tv_username_feedback)
        val image: ImageView = view.findViewById(R.id.iv_profile_feedback)
        val rating: RatingBar = view.findViewById(R.id.rb_rattingbar)
        val comment: TextView = view.findViewById(R.id.tv_comment_feedback)

        fun bindView(feedback: FeedbackModel, listener: (FeedbackModel) -> Unit){
            date.text = feedback.date
            name.text = feedback.name
            image.setImageResource(feedback.image)
            rating.rating = feedback.rating
            comment.text = feedback.comment
            itemView.setOnClickListener {
                listener(feedback)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_feedback, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = feedbackList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(feedbackList[position], listener)

        val feedback = feedbackList[position]
        holder.date.text = feedback.date
        holder.name.text = feedback.name
        holder.image.setImageResource(feedback.image)
        holder.rating.rating = feedback.rating
        holder.comment.text = feedback.comment
        itemCount

    }
}
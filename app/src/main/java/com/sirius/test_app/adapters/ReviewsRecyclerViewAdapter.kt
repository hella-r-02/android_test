package com.sirius.test_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirius.test_app.R
import com.sirius.test_app.ReviewModel
import de.hdodenhof.circleimageview.CircleImageView

class ReviewsRecyclerViewAdapter(private val reviews: List<ReviewModel>) :
    RecyclerView.Adapter<ReviewsRecyclerViewAdapter.InnerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_item, parent, false)
        return InnerHolder(view)
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        holder.bind(reviews[position])
    }

    inner class InnerHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(reviewModel: ReviewModel) {
            val imageReviewer = view.findViewById<CircleImageView>(R.id.image_reviewer)
            val nameReviewer = view.findViewById<TextView>(R.id.name_reviewer)
            val dateReviewer = view.findViewById<TextView>(R.id.date_reviewer)
            val review = view.findViewById<TextView>(R.id.review)
            nameReviewer.text = reviewModel.userName
            dateReviewer.text = reviewModel.date
            review.text = reviewModel.message
            Glide.with(view.context).load(reviewModel.userImage).centerCrop().into(imageReviewer)
        }
    }
}
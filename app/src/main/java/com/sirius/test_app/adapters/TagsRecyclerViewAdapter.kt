package com.sirius.test_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.R

class TagsRecyclerViewAdapter(private val tags: List<String>) :
    RecyclerView.Adapter<TagsRecyclerViewAdapter.InnerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        return InnerHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.tag_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        holder.bind(tags[position])
    }

    override fun getItemCount(): Int = tags.size

    inner class InnerHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(tag: String) {
            val tagTextView = view.findViewById<TextView>(R.id.tag_text)
            tagTextView.text = tag
        }
    }
}
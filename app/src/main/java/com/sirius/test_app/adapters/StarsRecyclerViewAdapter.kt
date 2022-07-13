package com.sirius.test_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.R

class StarsRecyclerViewAdapter(private val count: Int) :
    RecyclerView.Adapter<StarsRecyclerViewAdapter.InnerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        return InnerHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.star_item, parent, false)
        )
    }

    override fun onBindViewHolder(innerHolder: InnerHolder, position: Int) {
    }

    override fun getItemCount(): Int = count

    inner class InnerHolder(view: View) :
        RecyclerView.ViewHolder(view)
}
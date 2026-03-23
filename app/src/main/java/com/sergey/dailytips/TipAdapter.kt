package com.sergey.dailytips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipAdapter(private val tips: List<Tip>) :
    RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.tipImage)
        val day: TextView = itemView.findViewById(R.id.tipDay)
        val title: TextView = itemView.findViewById(R.id.tipTitle)
        val description: TextView = itemView.findViewById(R.id.tipDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]

        holder.image.setImageResource(tip.imageResId)
        holder.day.text = "Day ${tip.day}"
        holder.title.setText(tip.titleResId)
        holder.description.setText(tip.descriptionResId)
    }

    override fun getItemCount(): Int = tips.size
}
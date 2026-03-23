package com.sergey.dailytips

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipAdapter(private val tips: List<Tip>) :
    RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    // ViewHolder теперь "умный": он знает, какой объект Tip в нем лежит
    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.tipImage)
        val day: TextView = itemView.findViewById(R.id.tipDay)
        val title: TextView = itemView.findViewById(R.id.tipTitle)
        val description: TextView = itemView.findViewById(R.id.tipDescription)

        private var currentTip: Tip? = null

        init {
            itemView.setOnClickListener {
                currentTip?.let { tip ->
                    val context = itemView.context
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("TITLE_RES_ID", tip.titleResId)
                        putExtra("DESC_RES_ID", tip.descriptionResId)
                        putExtra("IMAGE_RES_ID", tip.imageResId)
                    }
                    context.startActivity(intent)
                }
            }
        }

        fun bind(tip: Tip) {
            currentTip = tip
            image.setImageResource(tip.imageResId)
            day.text = "Day ${tip.day}"
            title.setText(tip.titleResId)
            description.setText(tip.descriptionResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(tips[position])
    }

    override fun getItemCount(): Int = tips.size
}
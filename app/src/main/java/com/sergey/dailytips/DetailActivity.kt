package com.sergey.dailytips

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailImage = findViewById<ImageView>(R.id.detailImage)
        val detailTitle = findViewById<TextView>(R.id.detailTitle)
        val detailDescription = findViewById<TextView>(R.id.detailDescription)

        val titleResId = intent.getIntExtra("TITLE_RES_ID", 0)
        val descResId = intent.getIntExtra("DESC_RES_ID", 0)
        val imageResId = intent.getIntExtra("IMAGE_RES_ID", 0)

        if (titleResId != 0) detailTitle.setText(titleResId)
        if (descResId != 0) detailDescription.setText(descResId)
        if (imageResId != 0) detailImage.setImageResource(imageResId)
    }
}
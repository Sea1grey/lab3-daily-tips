package com.sergey.dailytips

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private fun getTipsList(): List<Tip> {
        val tips = mutableListOf<Tip>()

        val imageNames = listOf(
            "img_tip_1",
            "img_tip_2",
            "img_tip_3",
            "img_tip_4",
            "img_tip_5",
            "img_tip_6",
            "img_tip_7"
        )

        for (i in 1..30) {
            val titleRes = resources.getIdentifier("tip${i}_title", "string", packageName)
            val shortDescRes = resources.getIdentifier("tip${i}_short", "string", packageName)
            val fullDescRes = resources.getIdentifier("tip${i}_full", "string", packageName)

            val currentImageName = imageNames[(i - 1) % imageNames.size]

            val imageRes = resources.getIdentifier(currentImageName, "drawable", packageName)

            val finalImageRes = if (imageRes != 0) imageRes else R.drawable.ic_launcher_background

            tips.add(Tip(i, titleRes, shortDescRes, fullDescRes, finalImageRes))
        }

        return tips
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Получаем наш сгенерированный список
        val tips = getTipsList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipAdapter(tips)
    }
}


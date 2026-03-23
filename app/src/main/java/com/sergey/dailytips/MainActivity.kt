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

        for (i in 1..30) {

            val titleRes = resources.getIdentifier("tip${i}_title", "string", packageName)
            val shortDescRes = resources.getIdentifier("tip${i}_short", "string", packageName)
            val fullDescRes = resources.getIdentifier("tip${i}_full", "string", packageName)

            // В качестве картинки пока используем стандартный фон,
            val imageRes = R.drawable.ic_launcher_background

            tips.add(Tip(i, titleRes, shortDescRes, fullDescRes, imageRes))
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


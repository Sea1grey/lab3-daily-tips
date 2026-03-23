package com.sergey.dailytips

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val tips = listOf(
            Tip(1, R.string.tip1_title, R.string.tip1_desc, R.drawable.ic_launcher_background),
            Tip(2, R.string.tip2_title, R.string.tip2_desc, R.drawable.ic_launcher_background)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipAdapter(tips)
    }
}
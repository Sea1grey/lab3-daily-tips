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
            Tip(2, R.string.tip2_title, R.string.tip2_desc, R.drawable.ic_launcher_background),
            Tip(3, R.string.tip3_title, R.string.tip3_desc, R.drawable.ic_launcher_background),
            Tip(4, R.string.tip4_title, R.string.tip4_desc, R.drawable.ic_launcher_background),
            Tip(5, R.string.tip5_title, R.string.tip5_desc, R.drawable.ic_launcher_background),
            Tip(6, R.string.tip6_title, R.string.tip6_desc, R.drawable.ic_launcher_background),
            Tip(7, R.string.tip7_title, R.string.tip7_desc, R.drawable.ic_launcher_background),
            Tip(8, R.string.tip8_title, R.string.tip8_desc, R.drawable.ic_launcher_background),
            Tip(9, R.string.tip9_title, R.string.tip9_desc, R.drawable.ic_launcher_background),
            Tip(10, R.string.tip10_title, R.string.tip10_desc, R.drawable.ic_launcher_background),
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipAdapter(tips)
    }
}
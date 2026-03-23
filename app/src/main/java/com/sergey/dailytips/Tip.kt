package com.sergey.dailytips

data class Tip (
        val day: Int,
        val titleResId: Int,
        val shortDescResId: Int,
        val fullDescResId: Int,
        val imageResId: Int
)


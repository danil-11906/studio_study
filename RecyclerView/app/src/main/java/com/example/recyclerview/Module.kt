package com.example.recyclerview

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Module(
    val id: Int,
    @DrawableRes val imageId: Int,
    @StringRes val title: Int
)
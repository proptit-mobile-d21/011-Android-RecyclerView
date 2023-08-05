package dev.proptit.recyclerview.model

import androidx.annotation.DrawableRes

data class DemoItem(
    @DrawableRes val avatarId: Int = -1,
    val title: String,
    val des: String = "",
    var isSelected: Boolean = false
)

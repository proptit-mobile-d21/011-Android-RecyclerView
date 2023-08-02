package dev.proptit.recyclerview.model

import androidx.annotation.DrawableRes

data class Item(val title: String, @DrawableRes val icon: Int) {
    var isSelected: Boolean = false
}

package dev.proptit.recyclerview.model

import androidx.annotation.DrawableRes

data class Option(val title: String, @DrawableRes val icon: Int) : Item {
    var isSelected: Boolean = false
}

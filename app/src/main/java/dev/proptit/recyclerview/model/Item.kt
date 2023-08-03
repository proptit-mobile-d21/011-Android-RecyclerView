package dev.proptit.recyclerview.model

data class Item(val avatar: Int, val title: String) {
    var isSelected: Boolean = false
}
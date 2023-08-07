package dev.proptit.recyclerview.model

data class Item(val avatar: Int, val title: String) : IItem {
    var isSelected: Boolean = false
}
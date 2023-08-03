package dev.proptit.recyclerview.model

class Item(
    val title: String,
    val image: Int
){
    val subtitle: String
    init {
        subtitle = "unselected"
    }
}
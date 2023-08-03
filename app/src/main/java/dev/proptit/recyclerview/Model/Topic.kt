package dev.proptit.recyclerview.Model

sealed class Topic{
    data class Item(val image : Int, val title: String, var description: String, var isSelected : Boolean = false) : Topic()
    data class Header(val header : String) : Topic()
}

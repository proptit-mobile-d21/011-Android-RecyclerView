package dev.proptit.recyclerview.Model

data class Item(val image : Int, val title: String, var description: String, var isSelected : Boolean = false)
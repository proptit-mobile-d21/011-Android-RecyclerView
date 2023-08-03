package dev.proptit.recyclerview.model

interface ItemClickListener {
    fun onItemClick(item: Item)
    fun onItemLongClick(item: Item)

}
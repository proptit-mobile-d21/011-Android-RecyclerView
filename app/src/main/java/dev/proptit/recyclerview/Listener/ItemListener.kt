package dev.proptit.recyclerview.Listener

import dev.proptit.recyclerview.Model.Item

interface ItemListener {
    fun onItemClick(item : Item, position: Int)
    fun onItemLongClick(item : Item, position: Int)
}
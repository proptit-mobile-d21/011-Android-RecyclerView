package dev.proptit.recyclerview.Listener

import dev.proptit.recyclerview.Item

interface ItemListener {
    fun onItemClick(item : Item, position: Int)
    fun onItemLongClick(item : Item, position: Int)
}
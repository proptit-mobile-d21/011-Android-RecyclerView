package dev.proptit.recyclerview.Listener

import dev.proptit.recyclerview.Model.Topic

interface ItemListener {
    fun onItemClick(item : Topic.Item, position: Int)
    fun onItemLongClick(item : Topic.Item, position: Int)
}
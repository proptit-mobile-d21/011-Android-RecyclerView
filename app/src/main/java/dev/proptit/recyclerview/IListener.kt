package dev.proptit.recyclerview

import dev.proptit.recyclerview.model.Item

interface IListener {
    fun onClick(item: Item)
    fun onLongClick(item: Item, position: Int)
}
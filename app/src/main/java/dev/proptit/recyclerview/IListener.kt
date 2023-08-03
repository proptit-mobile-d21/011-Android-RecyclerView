package dev.proptit.recyclerview

import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.adapter.ChildAdapter
import dev.proptit.recyclerview.model.Item

interface IListener<T : RecyclerView.ViewHolder?> {
    fun onClick(item: Item)
    fun onLongClick(adapter: RecyclerView.Adapter<T>, item: Item, position: Int)
}
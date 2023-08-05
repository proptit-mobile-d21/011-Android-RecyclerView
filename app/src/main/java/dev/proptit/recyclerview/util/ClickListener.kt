package dev.proptit.recyclerview.util

import dev.proptit.recyclerview.databinding.ItemViewBinding
import dev.proptit.recyclerview.model.data.Item

interface ClickListener {
    fun onSingleClickListener(item: Item)
    fun onLongClickListener(item: Item)
}
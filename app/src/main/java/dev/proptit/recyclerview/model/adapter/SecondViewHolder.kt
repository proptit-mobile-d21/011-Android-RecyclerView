package dev.proptit.recyclerview.model.adapter

import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.StickyHeaderBinding
import dev.proptit.recyclerview.model.data.Item

class SecondViewHolder(private val binding: StickyHeaderBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item){
        binding.tvHeading.text = item.title
    }
}
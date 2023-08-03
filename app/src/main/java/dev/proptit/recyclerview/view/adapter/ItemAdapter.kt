package dev.proptit.recyclerview.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ItemViewBinding
import dev.proptit.recyclerview.model.Item

class ItemAdapter(
    var items: MutableList<Item>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = items[position].title
            tvSubtitle.text = items[position].subtitle
            ivAvatar.setImageResource(items[position].image)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
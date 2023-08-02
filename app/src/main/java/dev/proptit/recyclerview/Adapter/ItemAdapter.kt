package dev.proptit.recyclerview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.Item
import dev.proptit.recyclerview.Listener.ItemListener
import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.databinding.ItemCircleBinding

class ItemAdapter(private val itemData : List<Item>, private val listener : ItemListener) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val binding: ItemCircleBinding, private val listener : ItemListener) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.apply {
                img.setImageResource(item.image)
                tvTitle.text = item.title
                tvSelected.text = if(item.isSelected) "Selected" else "Not Selected"
                root.setOnClickListener {
                    listener.onItemClick(item, adapterPosition)
                }
                root.setOnLongClickListener {
                    listener.onItemLongClick(item, adapterPosition)
                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemCircleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false), listener)
    }

    override fun getItemCount(): Int {
        if(itemData != null){
            return itemData.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemData[position]
        holder.bind(currentItem)
    }
}
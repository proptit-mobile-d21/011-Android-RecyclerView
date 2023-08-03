package dev.proptit.recyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.Model.Item
import dev.proptit.recyclerview.Listener.ItemListener
import dev.proptit.recyclerview.Model.Header
import dev.proptit.recyclerview.databinding.ItemCircleBinding
import dev.proptit.recyclerview.databinding.ItemHeaderBinding

class ItemAdapter(private val itemData : List<Any>, private val listener : ItemListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

    class ItemViewHolder(private val binding: ItemCircleBinding, private val listener : ItemListener) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            binding.apply {
                img.setImageResource(item.image)
                tvTitle.text = item.title
                tvSelected.text = if(item.isSelected) "Selected" else "Unselected"
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

    class HeaderViewHolder(private val binding : ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(header : Header){
            binding.root.text = header.header
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> {
                val item = itemData[position] as Item
                holder.bind(item)
            }
            is HeaderViewHolder -> {
                val header = itemData[position] as Header
                holder.bind(header)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            TYPE_HEADER -> {
                val binding = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HeaderViewHolder(binding)
            }

            TYPE_ITEM -> {
                val binding = ItemCircleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder(binding, listener)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(itemData[position] is Header){
            return TYPE_HEADER
        }
        return TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return itemData.size
    }


}
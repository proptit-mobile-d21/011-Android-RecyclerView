package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.IListener
import dev.proptit.recyclerview.databinding.ItemCategoryBinding
import dev.proptit.recyclerview.databinding.ItemTitleGridBinding
import dev.proptit.recyclerview.databinding.ItemTitleListBinding
import dev.proptit.recyclerview.model.Category
import dev.proptit.recyclerview.model.IItem
import dev.proptit.recyclerview.model.Item

class Adapter(private val list: List<IItem>, private val listener: IListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val CATEGORY = 0
        const val ITEM_LIST = 1
        const val ITEM_GRID = 2
    }

    var isListLayout = true

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.apply {
                textHeader.text = category.header
            }
        }
    }

    inner class ItemListViewHolder(private val binding: ItemTitleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                avatar.setImageResource(item.avatar)
                textTitle.text = item.title
                textDescription.text = if (item.isSelected) "selected" else "unselected"
                itemCard.setOnClickListener {
                    listener.onClick(item)
                }
                itemCard.setOnLongClickListener {
                    listener.onLongClick(item, adapterPosition)
                    true
                }
            }
        }
    }

    inner class ItemGridViewHolder(private val binding: ItemTitleGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                avatar.setImageResource(item.avatar)
                textTitle.text = item.title
                textDescription.text = if (item.isSelected) "selected" else "unselected"
                itemCard.setOnClickListener {
                    listener.onClick(item)
                }
                itemCard.setOnLongClickListener {
                    listener.onLongClick(item, adapterPosition)
                    true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CATEGORY -> {
                val binding =
                    ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CategoryViewHolder(binding)
            }

            ITEM_LIST -> {
                val binding =
                    ItemTitleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemListViewHolder(binding)
            }

            ITEM_GRID -> {
                val binding =
                    ItemTitleGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemGridViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Illegal argument")
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Category -> CATEGORY
            is Item -> if (isListLayout) ITEM_LIST else ITEM_GRID
            else -> throw IllegalArgumentException("Illegal argument")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryViewHolder -> holder.bind(list[position] as Category)
            is ItemListViewHolder -> holder.bind(list[position] as Item)
            is ItemGridViewHolder -> holder.bind(list[position] as Item)
        }
    }
}
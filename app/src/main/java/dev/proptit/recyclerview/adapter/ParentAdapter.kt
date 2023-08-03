package dev.proptit.recyclerview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.IListener
import dev.proptit.recyclerview.databinding.ItemParentRecyclerViewBinding
import dev.proptit.recyclerview.model.Category
import dev.proptit.recyclerview.model.Item

class ParentAdapter(private val context: Context, private val categories: List<Category>) :
    RecyclerView.Adapter<ParentAdapter.ParentViewHolder>(),
    IListener<ChildAdapter.ChildViewHolder> {
    inner class ParentViewHolder(private val binding: ItemParentRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.apply {
                textHeader.text = category.header
                childRecyclerView.layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
                childRecyclerView.adapter = ChildAdapter(category.items, this@ParentAdapter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val binding =
            ItemParentRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ParentViewHolder(binding)
    }

    override fun getItemCount(): Int = categories.size
    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun onClick(item: Item) {
        Toast.makeText(context, "${item.title} clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(
        adapter: RecyclerView.Adapter<ChildAdapter.ChildViewHolder>,
        item: Item,
        position: Int
    ) {
        item.isSelected = !item.isSelected
        adapter.notifyItemChanged(position)
        Toast.makeText(
            context,
            "${item.title} is ${if (item.isSelected) "selected" else "unselected"}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
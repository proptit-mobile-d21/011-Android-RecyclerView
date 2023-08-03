package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.IListener
import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.databinding.ItemChildRecyclerViewBinding
import dev.proptit.recyclerview.model.Item

class ChildAdapter(
    private val items: List<Item>,
    private val listener: IListener<ChildViewHolder>
) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {
    inner class ChildViewHolder(private val binding: ItemChildRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.apply {
                avatar.setImageResource(R.drawable.avatar)
                textTitle.text = item.title
                textDescription.text = if (item.isSelected) "selected" else "unselected"
                itemCard.setOnClickListener {
                    listener.onClick(item)
                }
                itemCard.setOnLongClickListener {
                    listener.onLongClick(this@ChildAdapter, item, adapterPosition)
                    true
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding =
            ItemChildRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
package dev.proptit.recyclerview.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import dev.proptit.recyclerview.databinding.ItemViewBinding
import dev.proptit.recyclerview.model.Item

class ItemAdapter(
    private val items: MutableList<Item>,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {v: View ->
                val pos: Int = adapterPosition
                Toast.makeText(binding.root.context, "Item #${pos+1} is selected", Toast.LENGTH_SHORT).show()
            }
        }
    }


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
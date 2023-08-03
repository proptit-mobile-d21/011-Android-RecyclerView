package dev.proptit.recyclerview.model.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.databinding.ItemViewBinding
import dev.proptit.recyclerview.model.Item

class ItemAdapter(
    private val items: MutableList<Item>,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                val pos: Int = adapterPosition
                Toast.makeText(binding.root.context, "Item #${pos+1} is clicked", Toast.LENGTH_SHORT).show()
            }
            binding.root.setOnLongClickListener {
                val pos: Int = adapterPosition
                if(items[pos].getState()){
                    Toast.makeText(binding.root.context, "Item #${pos+1} is unselected", Toast.LENGTH_SHORT).show()
                    binding.tvSubtitle.text = Resources.getSystem().getString(R.string.unseclected)
                    items[pos].setState(false)
                }else{
                    Toast.makeText(binding.root.context, "Item #${pos+1} is selected", Toast.LENGTH_SHORT).show()
                    binding.tvSubtitle.text = Resources.getSystem().getString(R.string.selected)
                    items[pos].setState(true)
                }
                true
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
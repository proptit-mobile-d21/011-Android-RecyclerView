package dev.proptit.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ItemLayoutBinding


class ItemAdapter(
    private val items: MutableList<Item>,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), OnClickListener, OnLongClickListener {
        private lateinit var itemClickListener: ItemClickListener

        init{
            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)
        }

        fun setItemClickListener(itemClickListener: ItemClickListener) {
            this.itemClickListener = itemClickListener
        }

        override fun onClick(v: View?) {
            itemClickListener.onClick(v, layoutPosition, false )

        }

        override fun onLongClick(v: View?): Boolean {
            itemClickListener.onClick(v, layoutPosition, true)
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            txtTitle.text = items[position].title
            txtSelect.text = items[position].subtitle
            itemImage.setImageResource(items[position].image)
        }
        holder.setItemClickListener(object : ItemClickListener{
            override fun onClick(view: View?, position: Int, isLongClick: Boolean) {
                if(isLongClick){
                    val itemSelect = items[position]
                    if(!itemSelect.isSelected)
                    {
                        Toast.makeText(view?.context, "Item ${position + 1} is selected", Toast.LENGTH_SHORT).show()
                        holder.binding.apply {
                            txtSelect.text = "Selected"
                        }
                        itemSelect.isSelected = true
                    }
                    else{
                        Toast.makeText(view?.context, "Item ${position + 1} is unselected", Toast.LENGTH_SHORT).show()
                        holder.binding.apply {
                            txtSelect.text = "Unselected"
                        }
                        itemSelect.isSelected = false
                    }

                } else{
                    Toast.makeText(view?.context, "Item ${position + 1} clicked", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
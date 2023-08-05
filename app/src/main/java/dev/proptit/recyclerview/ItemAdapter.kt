package dev.proptit.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.HeaderLayoutBinding
import dev.proptit.recyclerview.databinding.ItemGridBinding
import dev.proptit.recyclerview.databinding.ItemLayoutBinding


class ItemAdapter(
    private val items: List<Data>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val DATA_HEADER = 1
        const val DATA_ITEM_LIST = 2
        const val DATA_ITEM_GRID = 3
    }

    var usingGridLayout : Boolean = false


    inner class ItemViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), OnClickListener, OnLongClickListener {
        private lateinit var itemClickListener: ItemClickListener


        init {

            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)
        }

        fun setItemClickListener(itemClickListener: ItemClickListener) {
            this.itemClickListener = itemClickListener
        }

        override fun onClick(v: View?) {
            itemClickListener.onClick(v, layoutPosition, false)

        }

        override fun onLongClick(v: View?): Boolean {
            itemClickListener.onClick(v, layoutPosition, true)
            return true
        }
    }

    inner class ItemGridHolder(val binding: ItemGridBinding) :
        RecyclerView.ViewHolder(binding.root), OnClickListener, OnLongClickListener {
        private lateinit var itemClickListener: ItemClickListener


        init {

            binding.root.setOnClickListener(this)
            binding.root.setOnLongClickListener(this)
        }

        fun setItemClickListener(itemClickListener: ItemClickListener) {
            this.itemClickListener = itemClickListener
        }

        override fun onClick(v: View?) {
            itemClickListener.onClick(v, layoutPosition, false)

        }

        override fun onLongClick(v: View?): Boolean {
            itemClickListener.onClick(v, layoutPosition, true)
            return true
        }
    }

    inner class HeaderViewHolder(val binding: HeaderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == DATA_HEADER) {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HeaderLayoutBinding.inflate(layoutInflater, parent, false)
            return HeaderViewHolder(binding)
        }
        else if(viewType == DATA_ITEM_LIST)
        {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
            return ItemViewHolder(binding)
        }
        else if(viewType == DATA_ITEM_GRID)
        {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemGridBinding = ItemGridBinding.inflate(layoutInflater, parent, false)
            return ItemGridHolder(binding)
        }
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            DATA_HEADER -> {
                (holder as HeaderViewHolder).binding.apply {
                    headerName.text = (items[position] as Header).title
                }
            }

            DATA_ITEM_LIST -> {
                (holder as ItemViewHolder).binding.apply{
                    txtTitle.text = (items[position] as Item).title
                    txtSelect.text = (items[position] as Item).subtitle
                    itemImage.setImageResource((items[position] as Item).image)

                }
                holder.setItemClickListener(object : ItemClickListener {
                    override fun onClick(view: View?, position: Int, isLongClick: Boolean) {
                        if (isLongClick) {
                            val itemSelect = items[position] as Item
                            if (!itemSelect.isSelected) {
                                Toast.makeText(
                                    view?.context,
                                    "${itemSelect.title} is selected",
                                    Toast.LENGTH_SHORT
                                ).show()
                                holder.binding.apply {
                                    txtSelect.text = "Selected"
                                }
                                itemSelect.isSelected = true
                            } else {
                                Toast.makeText(
                                    view?.context,
                                    "${itemSelect.title} is unselected",
                                    Toast.LENGTH_SHORT
                                ).show()
                                holder.binding.apply {
                                    txtSelect.text = "Unselected"
                                }
                                itemSelect.isSelected = false
                            }

                        } else {
                            val itemSelect = items[position] as Item
                            Toast.makeText(
                                view?.context,
                                "${itemSelect.title} is clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                })
            }
            DATA_ITEM_GRID -> {
                (holder as ItemGridHolder).binding.apply {
                    title.text = (items[position] as Item).title
                    subtitle.text = (items[position] as Item).subtitle
                  image.setImageResource((items[position] as Item).image)

                }
                holder.setItemClickListener(object : ItemClickListener {
                    override fun onClick(view: View?, position: Int, isLongClick: Boolean) {
                        if (isLongClick) {
                            val itemSelect = items[position] as Item
                            if (!itemSelect.isSelected) {
                                Toast.makeText(
                                    view?.context,
                                    "${itemSelect.title} is selected",
                                    Toast.LENGTH_SHORT
                                ).show()
                                holder.binding.apply {
                                    subtitle.text = "Selected"
                                }
                                itemSelect.isSelected = true
                            } else {
                                Toast.makeText(
                                    view?.context,
                                    "${itemSelect.title} is unselected",
                                    Toast.LENGTH_SHORT
                                ).show()
                                holder.binding.apply {
                                    subtitle.text = "Unselected"
                                }
                                itemSelect.isSelected = false
                            }

                        } else {
                            val itemSelect = items[position] as Item
                            Toast.makeText(
                                view?.context,
                                "${itemSelect.title} is clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                })
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]){
            is Header -> DATA_HEADER
            is Item -> if (usingGridLayout) DATA_ITEM_GRID else DATA_ITEM_LIST
            else -> 0
        }
    }
}
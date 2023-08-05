package dev.proptit.recyclerview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import dev.proptit.recyclerview.Listener.ItemListener
import dev.proptit.recyclerview.Model.Topic
import dev.proptit.recyclerview.databinding.ItemCircleBinding
import dev.proptit.recyclerview.databinding.ItemHeaderBinding

class ItemAdapter(private val itemData : List<Topic>, private val listener : ItemListener,
    private val onClick : (Topic.Item) -> Unit,
    private val onLongClick : (Topic.Item, Int) -> Unit
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

    sealed class ViewHolder(binding : ViewBinding) : RecyclerView.ViewHolder(binding.root){
        class ItemViewHolder(private val binding: ItemCircleBinding, private val listener : ItemListener) : RecyclerView.ViewHolder(binding.root){
            fun bind(item : Topic.Item,
                     onClick : (Topic.Item) -> Unit,
                     onLongClick : (Topic.Item, Int) -> Unit,
            ){
                binding.apply {
                    img.setImageResource(item.image)
                    tvTitle.text = item.title
                    tvSelected.text = if(item.isSelected) "Selected" else "Unselected"
                    root.setOnClickListener {
                       // listener.onItemClick(item, adapterPosition)
                        onClick(item)
                    }
                    root.setOnLongClickListener{
                        //listener.onItemLongClick(item, adapterPosition)
                        onLongClick(item, adapterPosition)
                        true
                    }


                }
            }
        }
        class HeaderViewHolder(private val binding : ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(header : Topic.Header){
                binding.root.text = header.header
            }
        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder.ItemViewHolder -> {
                val item = itemData[position] as Topic.Item
                holder.bind(item, onClick, onLongClick)
            }
            is ViewHolder.HeaderViewHolder -> {
                val header = itemData[position] as Topic.Header
                holder.bind(header)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            TYPE_HEADER -> {
                val binding = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolder.HeaderViewHolder(binding)
            }

            TYPE_ITEM -> {
                val binding = ItemCircleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolder.ItemViewHolder(binding, listener)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(itemData[position] is Topic.Header){
            return TYPE_HEADER
        }
        return TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return itemData.size
    }

}
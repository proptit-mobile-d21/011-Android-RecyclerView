package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.RecyclerViewItemBinding
import dev.proptit.recyclerview.model.Item

typealias ItemOnClick = (Item) -> Unit

class MyAdapter(private val list: List<Item>, private val itemOnClick: ItemOnClick):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : RecyclerViewItemBinding = RecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(binding, itemOnClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class MyViewHolder(private val binding: RecyclerViewItemBinding, private val itemOnClick: ItemOnClick) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.rcvItemIcon.setImageResource(item.icon)
            binding.rcvItemTitle.text = item.title
            binding.rcvItemSelectedTxt.text = if (item.isSelected) "selected" else "unselected"
            binding.root.setOnClickListener { itemOnClick.invoke(item) }
        }
    }
}
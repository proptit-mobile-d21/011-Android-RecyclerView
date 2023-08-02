package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.RecyclerViewItemBinding
import dev.proptit.recyclerview.model.IOptionListener
import dev.proptit.recyclerview.model.Option

class MyAdapter(private val list: List<Option>, private val optionListener: IOptionListener):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding : RecyclerViewItemBinding = RecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(binding, optionListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    class MyViewHolder(private val binding: RecyclerViewItemBinding, private val optionListener: IOptionListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(option: Option, position: Int) {
            binding.rcvItemIcon.setImageResource(option.icon)
            binding.rcvItemTitle.text = option.title
            binding.rcvItemSelectedTxt.text = if (option.isSelected) "selected" else "unselected"
            binding.root.setOnClickListener { optionListener.onClick(option) }
            binding.root.setOnLongClickListener {
                optionListener.onLongClick(option, position)
                true
            }
        }
    }
}
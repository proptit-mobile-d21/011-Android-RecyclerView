package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.RcvItemHeaderBinding
import dev.proptit.recyclerview.databinding.RcvItemOptionBinding
import dev.proptit.recyclerview.model.Header
import dev.proptit.recyclerview.model.IOptionListener
import dev.proptit.recyclerview.model.Item
import dev.proptit.recyclerview.model.Option

private const val ITEM_HEADER = 1
private const val ITEM_OPTION = 2

class MyAdapter(private val list: List<Item>, private val optionListener: IOptionListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_HEADER -> {
                val binding: RcvItemHeaderBinding = RcvItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                HeaderViewHolder(binding)
            }
            ITEM_OPTION -> {
                val binding: RcvItemOptionBinding = RcvItemOptionBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                OptionViewHolder(binding, optionListener)
            }
            else -> throw IllegalArgumentException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ITEM_HEADER -> (holder as HeaderViewHolder).bind(list[position] as Header)
            ITEM_OPTION -> (holder as OptionViewHolder).bind(list[position] as Option, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Header -> ITEM_HEADER
            is Option -> ITEM_OPTION
            else -> 0
        }
    }

    override fun getItemCount(): Int = list.size

    class HeaderViewHolder(private val binding: RcvItemHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(header: Header) {
            binding.root.text = header.title
        }
    }

    class OptionViewHolder(private val binding: RcvItemOptionBinding, private val optionListener: IOptionListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(option: Option, position: Int) {
            binding.rcvOptionIcon.setImageResource(option.icon)
            binding.rcvOptionTitle.text = option.title
            binding.rcvOptionSelectedTxt.text = if (option.isSelected) "selected" else "unselected"
            binding.root.setOnClickListener { optionListener.onClick(option) }
            binding.root.setOnLongClickListener {
                optionListener.onLongClick(option, position)
                true
            }
        }
    }
}
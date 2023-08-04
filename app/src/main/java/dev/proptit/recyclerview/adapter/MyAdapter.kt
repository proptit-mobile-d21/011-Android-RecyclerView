package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import dev.proptit.recyclerview.databinding.RcvItemHeaderBinding
import dev.proptit.recyclerview.databinding.RcvItemOptionGridBinding
import dev.proptit.recyclerview.databinding.RcvItemOptionLinearBinding
import dev.proptit.recyclerview.model.Header
import dev.proptit.recyclerview.model.IOptionListener
import dev.proptit.recyclerview.model.Item
import dev.proptit.recyclerview.model.Option

class MyAdapter(private val list: List<Item>, private val optionListener: IOptionListener):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val ITEM_HEADER = 1
        const val ITEM_OPTION_LINEAR = 2
        const val ITEM_OPTION_GRID = 3
    }

    var usingGridLayout : Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_HEADER -> {
                val binding: RcvItemHeaderBinding = RcvItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                HeaderViewHolder(binding)
            }
            ITEM_OPTION_LINEAR -> {
                val binding: RcvItemOptionLinearBinding = RcvItemOptionLinearBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                object : OptionViewHolder(binding, optionListener) {
                    override val icon: ImageView = binding.rcvOptionIcon
                    override val title: TextView = binding.rcvOptionTitle
                    override val selectedText: TextView = binding.rcvOptionSelectedTxt
                }
            }
            ITEM_OPTION_GRID -> {
                val binding: RcvItemOptionGridBinding = RcvItemOptionGridBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                object : OptionViewHolder(binding, optionListener) {
                    override val icon: ImageView = binding.rcvOptionIcon
                    override val title: TextView = binding.rcvOptionTitle
                    override val selectedText: TextView = binding.rcvOptionSelectedTxt
                }
            }
            else -> throw IllegalArgumentException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ITEM_HEADER -> (holder as HeaderViewHolder).bind(list[position] as Header)
            else -> (holder as OptionViewHolder).bind(list[position] as Option, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Header -> ITEM_HEADER
            is Option -> if (usingGridLayout) ITEM_OPTION_GRID else ITEM_OPTION_LINEAR
            else -> 0
        }
    }

    override fun getItemCount(): Int = list.size

    private class HeaderViewHolder(private val binding: RcvItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(header: Header) {
            binding.root.text = header.title
        }
    }

    private abstract class OptionViewHolder(
        binding: ViewBinding,
        private val optionListener: IOptionListener
    ) : RecyclerView.ViewHolder(binding.root) {

        protected abstract val icon: ImageView?
        protected abstract val title: TextView?
        protected abstract val selectedText: TextView?

        fun bind(option: Option, position: Int) {
            icon?.setImageResource(option.icon)
            title?.text = option.title
            selectedText?.text = if (option.isSelected) "selected" else "unselected"
            itemView.setOnClickListener { optionListener.onClick(option) }
            itemView.setOnLongClickListener {
                optionListener.onLongClick(option, position)
                true
            }
        }
    }
}
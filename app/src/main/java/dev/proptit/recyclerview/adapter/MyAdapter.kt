package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
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
                OptionLinearViewHolder(binding, optionListener)
            }
            ITEM_OPTION_GRID -> {
                val binding: RcvItemOptionGridBinding = RcvItemOptionGridBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                OptionGridViewHolder(binding, optionListener)
            }
            else -> throw IllegalArgumentException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ITEM_HEADER -> (holder as HeaderViewHolder).bind(list[position] as Header)
            ITEM_OPTION_LINEAR -> (holder as OptionLinearViewHolder).bind(list[position] as Option, position)
            ITEM_OPTION_GRID -> (holder as OptionGridViewHolder).bind(list[position] as Option, position)
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

    class HeaderViewHolder(private val binding: RcvItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(header: Header) {
            binding.root.text = header.title
        }
    }

    abstract class OptionViewHolder(
        private val binding: ViewBinding,
        private val optionListener: IOptionListener
    ) : RecyclerView.ViewHolder(binding.root) {

        open fun bind(option: Option, position: Int) {
            binding.root.setOnClickListener { optionListener.onClick(option) }
            binding.root.setOnLongClickListener {
                optionListener.onLongClick(option, position)
                true
            }
        }
    }

    class OptionLinearViewHolder(
        private val binding: RcvItemOptionLinearBinding,
        optionListener: IOptionListener
    ) : OptionViewHolder(binding, optionListener) {

        override fun bind(option: Option, position: Int) {
            super.bind(option, position)
            binding.rcvOptionIcon.setImageResource(option.icon)
            binding.rcvOptionTitle.text = option.title
            binding.rcvOptionSelectedTxt.text = if (option.isSelected) "selected" else "unselected"
        }
    }

    class OptionGridViewHolder(
        private val binding: RcvItemOptionGridBinding,
        optionListener: IOptionListener
    ) : OptionViewHolder(binding, optionListener) {

        override fun bind(option: Option, position: Int) {
            super.bind(option, position)
            binding.rcvOptionIcon.setImageResource(option.icon)
            binding.rcvOptionTitle.text = option.title
            binding.rcvOptionSelectedTxt.text = if (option.isSelected) "selected" else "unselected"
        }
    }
}
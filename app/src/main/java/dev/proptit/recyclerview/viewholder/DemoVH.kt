package dev.proptit.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import dev.proptit.recyclerview.model.DemoItem
import dev.proptit.recyclerview.adapter.ItemClickCallback

abstract class DemoVH(private val mBinding: ViewBinding) : ViewHolder(mBinding.root) {
    open fun bind(item: DemoItem, onClickListener: ItemClickCallback) {
        itemView.apply {
            setOnClickListener { onClickListener.onClick(item.title) }
            setOnLongClickListener {
                onClickListener.onLongClick(item.title, item.isSelected.not())
                true
            }
        }
    }
}
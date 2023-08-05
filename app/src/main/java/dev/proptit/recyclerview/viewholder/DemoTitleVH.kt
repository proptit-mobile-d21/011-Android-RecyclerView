package dev.proptit.recyclerview.viewholder

import dev.proptit.recyclerview.adapter.ItemClickCallback
import dev.proptit.recyclerview.databinding.DemoTitleLayoutBinding
import dev.proptit.recyclerview.model.DemoItem

class DemoTitleVH(private val mBinding: DemoTitleLayoutBinding) : DemoVH(mBinding) {
    override fun bind(item: DemoItem, onClickListener: ItemClickCallback) {
        mBinding.apply {
            tvTitle.text = item.title
        }
    }
}
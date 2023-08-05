package dev.proptit.recyclerview.viewholder

import android.annotation.SuppressLint
import dev.proptit.recyclerview.model.DemoItem
import dev.proptit.recyclerview.adapter.ItemClickCallback
import dev.proptit.recyclerview.databinding.DemoItemListLayoutBinding

class DemoListVH(private val mBinding: DemoItemListLayoutBinding) : DemoVH(mBinding) {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bind(item: DemoItem, onClickListener: ItemClickCallback) {
        mBinding.apply {
            imvAvatar.setImageResource(item.avatarId)
            tvTitle.text = item.title
            tvDescription.text = item.des
            tvDescription.text = if(item.isSelected) "selected" else "unselected"
//            lnlContainer.background =
//                itemView.context.getDrawable(if (item.isSelected) R.drawable.item_ripple_selected else R.drawable.item_ripple_selected)
            //lnlContainer.setBackgroundColor(if (item.isSelected) Color.GRAY else Color.WHITE)
        }

        super.bind(item, onClickListener)
    }
}
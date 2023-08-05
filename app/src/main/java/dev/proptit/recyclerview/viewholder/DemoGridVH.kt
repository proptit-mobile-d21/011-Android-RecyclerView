package dev.proptit.recyclerview.viewholder

import android.annotation.SuppressLint
import dev.proptit.recyclerview.model.DemoItem
import dev.proptit.recyclerview.adapter.ItemClickCallback
import dev.proptit.recyclerview.databinding.DemoItemGridLayoutBinding

class DemoGridVH(private val mBinding: DemoItemGridLayoutBinding) : DemoVH(mBinding) {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bind(item: DemoItem, onClickListener: ItemClickCallback) {
        mBinding.apply {
            imvAvatar.setImageResource(item.avatarId)
            tvTitle.text = item.title
            tvDescription.text = if(item.isSelected) "selected" else "unselected"
//            ctlContainer.background =
//                itemView.context.getDrawable(if (item.isSelected) R.drawable.item_ripple_selected else R.drawable.item_ripple_selected)
            //ctlContainer.setBackgroundColor(if (item.isSelected) Color.GRAY else Color.WHITE)
        }

        super.bind(item, onClickListener)
    }
}
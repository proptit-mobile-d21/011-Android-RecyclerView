package dev.proptit.recyclerview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import dev.proptit.recyclerview.databinding.DemoItemGridLayoutBinding
import dev.proptit.recyclerview.databinding.DemoItemListLayoutBinding
import dev.proptit.recyclerview.databinding.DemoTitleLayoutBinding
import dev.proptit.recyclerview.model.DemoItem
import dev.proptit.recyclerview.viewholder.DemoGridVH
import dev.proptit.recyclerview.viewholder.DemoListVH
import dev.proptit.recyclerview.viewholder.DemoTitleVH
import dev.proptit.recyclerview.viewholder.DemoVH

interface ItemClickCallback {
    fun onClick(title: String)
    fun onLongClick(title: String, isSelected: Boolean)
}

enum class LayoutType {
    LINEAR,
    GRID
}

class DemoAdapter(
    private val itemClickCallback: ItemClickCallback,
    private var layoutType: LayoutType = LayoutType.LINEAR
) : Adapter<DemoVH>() {
    private val mData: MutableList<DemoItem> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<DemoItem>) {
        mData.clear()
        mData.addAll(newData)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateLayout(layoutType: LayoutType) {
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val item = mData[position]

        return if (item.avatarId == -1)
            -1
        else layoutType.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoVH {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            LayoutType.LINEAR.ordinal -> DemoListVH(
                DemoItemListLayoutBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            LayoutType.GRID.ordinal -> DemoGridVH(
                DemoItemGridLayoutBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            else -> DemoTitleVH(DemoTitleLayoutBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: DemoVH, position: Int) {
        val item = mData[position]
        holder.bind(item, object : ItemClickCallback {
            override fun onClick(title: String) {
                itemClickCallback.onClick(title)
            }

            override fun onLongClick(title: String, isSelected: Boolean) {
                item.isSelected = isSelected
                notifyItemChanged(holder.adapterPosition)
                itemClickCallback.onLongClick(title, isSelected)
            }
        })
    }
}
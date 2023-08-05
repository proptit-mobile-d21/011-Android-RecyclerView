package dev.proptit.recyclerview.model.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.databinding.ItemViewBinding
import dev.proptit.recyclerview.databinding.StickyHeaderBinding
import dev.proptit.recyclerview.model.data.Item
import dev.proptit.recyclerview.util.ClickListener

class ItemAdapter(
    private val items: MutableList<Item>,
    private val onSingleClick: ((item: Item) -> Unit),
    private val onLongClick: ((item: Item) -> Unit),
    private val listener: ClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val FIRST_VIEW = 1
        const val SECOND_VIEW = 2
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when(viewType){
            FIRST_VIEW -> FirstViewHolder(ItemViewBinding.inflate(layoutInflater, parent, false), items, listener)
            SECOND_VIEW -> SecondViewHolder(StickyHeaderBinding.inflate(layoutInflater, parent, false))
            else -> throw IllegalArgumentException(viewType.toString())
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when(items[position].viewType){
            FIRST_VIEW -> (holder as FirstViewHolder).bind(items[position])
            SECOND_VIEW -> (holder as SecondViewHolder).bind(items[position])
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

}
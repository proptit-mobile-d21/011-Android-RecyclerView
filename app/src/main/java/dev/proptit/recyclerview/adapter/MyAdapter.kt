package dev.proptit.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.model.Item
import dev.proptit.recyclerview.model.ItemClickListener

class MyAdapter(private val itemList: List<Item>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View, private val listener: ItemClickListener) : RecyclerView.ViewHolder(itemView) {
        private val mAvt: ImageView = itemView.findViewById(R.id.im_avt)
        private val mTitle: TextView = itemView.findViewById(R.id.text_title)
        private val mSelected: TextView = itemView.findViewById(R.id.text_status)

        fun bind(item: Item) {
            mAvt.setImageResource(item.image)
            mTitle.text = item.title
            mSelected.text = if (item.isSelected) "Selected" else "Unselected"

            itemView.setOnClickListener {
                val clickedItem = itemList[adapterPosition]
                listener.onItemClick(clickedItem)
            }

            itemView.setOnLongClickListener {
                val clickedItem = itemList[adapterPosition]
                clickedItem.isSelected = !clickedItem.isSelected
                mSelected.text = if (clickedItem.isSelected) "Selected" else "Unselected"
                listener.onItemLongClick(clickedItem)
                true
            }
        }
    }
}
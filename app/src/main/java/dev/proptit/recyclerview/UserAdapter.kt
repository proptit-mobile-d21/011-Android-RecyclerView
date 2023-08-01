package dev.proptit.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ItemBinding

data class Item(val resourceId: Int,val title: String, val status: String)

class UserAdapter(private val listItem : List<Item>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(item: Item) {
            binding.image.setImageResource(item.resourceId)
            binding.title.text = item.title
            binding.status.text = item.status
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (binding.status.text.toString().equals("selected")) {
                binding.status.text = "unselected"
            }
            else {
                binding.status.text = "selected"
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(resourceId: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItem[position])
    }
}



package dev.proptit.recyclerview.model.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.databinding.ItemViewBinding
import dev.proptit.recyclerview.model.data.Item
import dev.proptit.recyclerview.util.ClickListener

class FirstViewHolder(private val binding: ItemViewBinding,
                      private val items: MutableList<Item>,
                      private val listener: ClickListener
): RecyclerView.ViewHolder(binding.root), View.OnLongClickListener, View.OnClickListener {

    init{
//        binding.root.setOnClickListener {
//            val pos: Int = adapterPosition
//            Toast.makeText(binding.root.context, "Item #${pos+1} is clicked", Toast.LENGTH_SHORT).show()
//        }
//        binding.root.setOnLongClickListener {
//            val pos: Int = adapterPosition
//            if(items[pos].getState()){
//                Toast.makeText(binding.root.context, "Item #${pos+1} is unselected", Toast.LENGTH_SHORT).show()
//                binding.tvSubtitle.text = this.itemView.context.getString(R.string.unselected)
//                items[pos].setState(false)
//            }else{
//                Toast.makeText(binding.root.context, "Item #${pos+1} is selected", Toast.LENGTH_SHORT).show()
//                binding.tvSubtitle.text = this.itemView.context.getString(R.string.selected)
//                items[pos].setState(true)
//            }
//            true
//        }
    }
    fun bind(item: Item){
        binding.tvTitle.text = item.title
        binding.tvSubtitle.text = item.subtitle
        binding.ivAvatar.setImageResource(item.image)
        binding.root.setOnClickListener(this)
        binding.root.setOnLongClickListener(this)
    }

    override fun onLongClick(v: View?): Boolean {
        val item: Item = items[adapterPosition]
        listener.onLongClickListener(item)
        val pos: Int = adapterPosition
            if(items[pos].getState()){
                Toast.makeText(binding.root.context, "Item #${pos+1} is unselected", Toast.LENGTH_SHORT).show()
                binding.tvSubtitle.text = this.itemView.context.getString(R.string.unselected)
                items[pos].setState(false)
            }else{
                Toast.makeText(binding.root.context, "Item #${pos+1} is selected", Toast.LENGTH_SHORT).show()
                binding.tvSubtitle.text = this.itemView.context.getString(R.string.selected)
                items[pos].setState(true)
            }

        return true
    }

    override fun onClick(v: View?) {
        val item: Item = items[adapterPosition]
        val pos: Int = adapterPosition
        Toast.makeText(binding.root.context, "Item #${pos+1} is clicked", Toast.LENGTH_SHORT).show()
        listener.onSingleClickListener(item)
    }
}
package com.example.android_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android_recyclerview.model.Data

class RecyclerViewAdapter (private val itemList : ArrayList<Data>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.name.text = currentItem.mName
        holder.image.setImageResource(currentItem.mImage)
        holder.des.text = currentItem.mDes
        holder.itemView.setOnLongClickListener() {
            if(holder.des.text.toString() == "Unselected")holder.des.text = "Selected"
            else holder.des.text = "Unselected"
            Toast.makeText(holder.itemView.context,"${currentItem.mName} ${holder.des.text}", Toast.LENGTH_SHORT).show()
             true
        }
        holder.itemView.setOnClickListener(){
            Toast.makeText(holder.itemView.context,"${currentItem.mName} click", Toast.LENGTH_SHORT).show()
        }
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.item_name)
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val des: TextView = itemView.findViewById(R.id.item_des)

    }

}
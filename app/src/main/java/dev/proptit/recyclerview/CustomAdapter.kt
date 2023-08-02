package dev.proptit.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mDataSet : Array<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val titleTextView : TextView
        val selectedTextView : TextView
        init{
            titleTextView = view.findViewById(R.id.title_text_view)
            selectedTextView = view.findViewById(R.id.selected_text_view)
        }

        fun setTitleTextView(string : String){
            titleTextView.text = string
        }

        fun setSelectedTextView(string : String){
            selectedTextView.text = string
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setTitleTextView(mDataSet[position])
        holder.setSelectedTextView(mDataSet[position])
    }
}
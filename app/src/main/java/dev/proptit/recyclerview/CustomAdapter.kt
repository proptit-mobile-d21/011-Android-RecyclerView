package dev.proptit.recyclerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class DataItem(
    val imageResId: Int,
    val name: String,
    val description: String
)
class CustomAdapter(private val dataList: List<DataItem>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar : ImageView = itemView.findViewById(R.id.avatar)
        val name : TextView = itemView.findViewById(R.id.name)
        val description : TextView = itemView.findViewById(R.id.description)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.avatar.setImageResource(item.imageResId)
        holder.name.text = item.name
        holder.description.text = item.description
    }
    override fun getItemCount(): Int = dataList.size
}
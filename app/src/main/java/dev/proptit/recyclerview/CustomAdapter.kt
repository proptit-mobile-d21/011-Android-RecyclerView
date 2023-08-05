package dev.proptit.recyclerview
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.Team
class CustomAdapter(private val context : Context, private val dataList: List<DataItem>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar : ImageView = itemView.findViewById(R.id.avatar)
        val name : TextView = itemView.findViewById(R.id.name)
        val description : TextView = itemView.findViewById(R.id.description)
        fun bind(item: DataItem) {
            avatar.setImageResource(item.imageResId)
            name.text = item.name
            description.text = item.description
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            Toast.makeText(context,item.name+ " clicked",Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnLongClickListener {
            if(!item.selected) {
                Toast.makeText(context, item.name + " selected", Toast.LENGTH_SHORT).show()
                Team.addCharacter(item)
                item.selected=true
            }else{
                Toast.makeText(context, item.name + " unselected", Toast.LENGTH_SHORT).show()
                Team.removeCharacter(item)
                item.selected=false
            }
            true
        }
    }
    override fun getItemCount(): Int = dataList.size
}
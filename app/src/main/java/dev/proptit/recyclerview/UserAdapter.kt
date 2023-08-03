package dev.proptit.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ItemBinding
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter

data class ItemModel(val headerText: String, val resourceId: Int, val title: String, val status: String)

class UserAdapter(private val listItem: List<ItemModel>) : BaseAdapter(), StickyListHeadersAdapter {
    override fun getCount(): Int {
        return listItem.size
    }
    // trả về kích thước danh sách
    override fun getItem(p0: Int): Any {
        return listItem[p0]
    }
    // trả về vị trí
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1 ?: LayoutInflater.from(p2?.context)
            .inflate(R.layout.item, p2, false)

        val item = listItem[p0]
        val title: TextView = view.findViewById(R.id.title)
        title.text = item.title
        val status: TextView = view.findViewById(R.id.status)
        status.text = item.status
        val image: ImageView = view.findViewById(R.id.image)
        image.setImageResource(item.resourceId)

        return view
    }

    override fun getHeaderView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.layout_header, parent, false)

        val item = listItem[position]
        val headerText: TextView = view.findViewById(R.id.header)
        headerText.text = item.headerText

        return view
    }

    override fun getHeaderId(position: Int): Long {
        return listItem[position].headerText.subSequence(0,15).hashCode().toLong()
    }

}



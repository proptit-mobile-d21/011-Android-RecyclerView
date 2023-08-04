package dev.proptit.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

open class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view),
    View.OnClickListener, View.OnLongClickListener {
    private val titleTextView : TextView

    init{
        titleTextView = view.findViewById(R.id.title_text_view)
    }

    fun setTitleTextView(string : String){
        titleTextView.text = string
    }
    open fun setSelectedTextView(string : String){
    }
    open fun setImageView(imageName: String){
    }

    override fun onClick(view: View?) {
    }

    override fun onLongClick(view: View?): Boolean {
        return false
    }
}
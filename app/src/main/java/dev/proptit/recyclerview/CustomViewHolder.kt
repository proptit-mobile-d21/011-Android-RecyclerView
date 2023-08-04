package dev.proptit.recyclerview

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class CustomViewHolder(view : View, private val dataSet: Array<DataSet>?) : RecyclerView.ViewHolder(view),
    View.OnClickListener, View.OnLongClickListener {
    private val titleTextView : TextView
    private val selectedTextView : TextView
    private val imageView : ShapeableImageView

    init{
        titleTextView = view.findViewById(R.id.title_text_view)
        selectedTextView = view.findViewById(R.id.selected_text_view)
        imageView = view.findViewById(R.id.image_view)

        view.setOnClickListener(this)
        view.setOnLongClickListener(this)
    }

    fun setTitleTextView(string : String){
        titleTextView.text = string
    }
    fun setSelectedTextView(string : String){
        selectedTextView.text = string
    }
    fun setImageView(imageName: String){
        val drawableResId = imageView.context.resources.getIdentifier(imageName, "drawable", imageView.context.packageName)
        imageView.setImageResource(drawableResId)
    }
    override fun onClick(view: View?) {
        val position: Int = layoutPosition
        if (position >= 0) {
            Toast.makeText(view?.context, "Item ${layoutPosition + 1} clicked", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onLongClick(view: View?): Boolean {
        val position: Int = layoutPosition
        if (position >= 0) {
            val selectedItem = dataSet?.get(position)
            if (selectedItem?.mIsSelected == true) {
                Toast.makeText(view?.context, "Item ${layoutPosition + 1} unselected", Toast.LENGTH_SHORT).show()
                selectedItem.mIsSelected = false
                setSelectedTextView("unselected")
            } else {
                Toast.makeText(view?.context, "Item ${layoutPosition + 1} selected", Toast.LENGTH_SHORT).show()
                selectedItem?.mIsSelected = true
                setSelectedTextView("selected")
            }
            return true
        }
        return false
    }
}
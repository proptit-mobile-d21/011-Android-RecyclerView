package dev.proptit.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class CustomAdapter(private val mDataSet : Array<DataSet>?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view : View, private val dataSet: Array<DataSet>?) : RecyclerView.ViewHolder(view), OnClickListener, OnLongClickListener{
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
                    Toast.makeText(view?.context, "Item ${layoutPosition + 1} deselected", Toast.LENGTH_SHORT).show()
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view, mDataSet)
    }

    override fun getItemCount(): Int {
        return mDataSet?.size ?: -1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            setTitleTextView(mDataSet?.get(position)?.mTitle ?: "Null")
            setSelectedTextView(mDataSet?.get(position)?.mSelected ?: "Null")
            setImageView(mDataSet?.get(position)?.mImageName ?: "Null")
        }
    }
}
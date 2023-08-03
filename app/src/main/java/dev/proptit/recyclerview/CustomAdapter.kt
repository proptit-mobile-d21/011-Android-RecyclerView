package dev.proptit.recyclerview

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class CustomAdapter(private val mDataSet : Array<DataSet>?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val titleTextView : TextView
        val selectedTextView : TextView
        val imageView : ShapeableImageView
        init{
            titleTextView = view.findViewById(R.id.title_text_view)
            selectedTextView = view.findViewById(R.id.selected_text_view)
            imageView = view.findViewById(R.id.image_view)
        }

        fun setTitleTextView(string : String){
            titleTextView.text = string
        }
        fun setSelectedTextView(string : String){
            selectedTextView.text = string
        }
        fun setImageView(imageName: String){
            val drawableResId = imageView.context.resources.getIdentifier(imageName, "drawable", imageView.context.packageName)
            imageView.background = ContextCompat.getDrawable(imageView.context, drawableResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
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
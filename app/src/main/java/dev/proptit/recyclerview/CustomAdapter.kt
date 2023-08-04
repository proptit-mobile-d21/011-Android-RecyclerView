package dev.proptit.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

enum class ViewType(val viewType: Int){
    SECTION_SET(1),
    DATA_SET(2)
}

class CustomAdapter(private val mDataSet : Array<DataSet>?, private val mSectionSet: Array<SectionSet>?) : RecyclerView.Adapter<CustomViewHolder>() {
    var itemSet = listOf<RecyclerViewItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return when(viewType){
            ViewType.SECTION_SET.viewType -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_section_item, parent, false)
                return SectionTypeViewHolder(view)
            }
            ViewType.DATA_SET.viewType-> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_content_item, parent, false)
                DataTypeViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return  itemSet.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemSet[position] is SectionSet) {
            ViewType.SECTION_SET.viewType
        } else {
            ViewType.DATA_SET.viewType
        }
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Log.d("CustomAdapter", "onBindViewHolder - position: $position, ${itemSet[position]}")
        holder.apply {
            if (holder is SectionTypeViewHolder && itemSet[position] is SectionSet) {
                when(position){
                    0 -> setTitleTextView(mSectionSet?.get(0)?.mTitle ?: "Null")
                    9 -> setTitleTextView(mSectionSet?.get(1)?.mTitle ?: "Null")
                    12 -> setTitleTextView(mSectionSet?.get(2)?.mTitle ?: "Null")
                }

            }
            if (holder is DataTypeViewHolder && itemSet[position] is DataSet) {
                when (position) {
                    in 1..8 -> {
                        setTitleTextView(mDataSet?.get(position - 1)?.mTitle ?: "Null")
                        setSelectedTextView(mDataSet?.get(position - 1)?.mSelected ?: "Null")
                        setImageView(mDataSet?.get(position - 1)?.mImageName ?: "Null")
                    }
                    in 10.. 12 -> {
                        setTitleTextView(mDataSet?.get(position - 2)?.mTitle ?: "Null")
                        setSelectedTextView(mDataSet?.get(position - 2)?.mSelected ?: "Null")
                        setImageView(mDataSet?.get(position - 2)?.mImageName ?: "Null")
                    }
                    else -> {
                        setTitleTextView(mDataSet?.get(position - 3)?.mTitle ?: "Null")
                        setSelectedTextView(mDataSet?.get(position - 3)?.mSelected ?: "Null")
                        setImageView(mDataSet?.get(position - 3)?.mImageName ?: "Null")
                    }
                }

            }
        }
    }

    inner class SectionTypeViewHolder(view : View) : CustomViewHolder(view)

    inner class DataTypeViewHolder(view : View) : CustomViewHolder(view){
        private val selectedTextView : TextView
        private val imageView : ShapeableImageView
        init{
            selectedTextView = view.findViewById(R.id.selected_text_view)
            imageView = view.findViewById(R.id.image_view)
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }
        override fun setSelectedTextView(string : String){
            selectedTextView.text = string
        }
        override fun setImageView(imageName: String){
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
                val selectedItem = when (position) {
                    in 1..8 -> {
                        mDataSet?.get(position - 1)
                    }
                    in 10.. 12 -> {
                        mDataSet?.get(position - 2)
                    }
                    else -> {
                        mDataSet?.get(position - 3)
                    }
                }
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
}
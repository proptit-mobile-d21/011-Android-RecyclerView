package dev.proptit.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mDataSet : Array<DataSet>?) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_content_item, parent, false)
        return CustomViewHolder(view, mDataSet)
    }

    override fun getItemCount(): Int {
        return mDataSet?.size ?: -1
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.apply {
            setTitleTextView(mDataSet?.get(position)?.mTitle ?: "Null")
            setSelectedTextView(mDataSet?.get(position)?.mSelected ?: "Null")
            setImageView(mDataSet?.get(position)?.mImageName ?: "Null")
        }
    }
}
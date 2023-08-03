package dev.proptit.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.adapter.MyAdapter
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import dev.proptit.recyclerview.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: MutableList<Item>
    private lateinit var mAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerDisplay()
    }

    private fun setRecyclerDisplay() {
        recyclerView = binding.recyclerView
        addItem()

        mAdapter = MyAdapter(itemList)
        recyclerView.adapter = mAdapter

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun addItem() {
        itemList = mutableListOf()

        itemList.add(Item(R.drawable.im_1, "Title 1", false))
        itemList.add(Item(R.drawable.im_2, "Title 2", false))
        itemList.add(Item(R.drawable.im_3, "Title 3", false))
        itemList.add(Item(R.drawable.im_4, "Title 4", false))
        itemList.add(Item(R.drawable.im_5, "Title 5", false))
        itemList.add(Item(R.drawable.im_6, "Title 6", false))
        itemList.add(Item(R.drawable.im_7, "Title 7", false))
        itemList.add(Item(R.drawable.im_3, "Title 8", false))
        itemList.add(Item(R.drawable.im_4, "Title 9", false))
        itemList.add(Item(R.drawable.im_5, "Title 10", false))
    }
}
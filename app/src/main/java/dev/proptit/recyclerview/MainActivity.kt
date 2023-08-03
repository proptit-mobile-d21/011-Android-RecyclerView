package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = mutableListOf<ItemModel>()
        itemList.add(ItemModel("Sticky Header 1", R.drawable.image_1, "Title 1", "unselected"))
        itemList.add(ItemModel("Sticky Header 1", R.drawable.image_2, "Title 2", "unselected"))
        itemList.add(ItemModel("Sticky Header 1", R.drawable.image_3, "Title 3", "unselected"))
        itemList.add(ItemModel("Sticky Header 1", R.drawable.image_4, "Title 4", "unselected"))
        itemList.add(ItemModel("Sticky Header 1", R.drawable.image_5, "Title 5", "unselected"))
        itemList.add(ItemModel("Sticky Header 1", R.drawable.image_6, "Title 6", "unselected"))

        itemList.add(ItemModel("Sticky Header 2", R.drawable.image_1, "Title 7", "unselected"))
        itemList.add(ItemModel("Sticky Header 2", R.drawable.image_2, "Title 8", "unselected"))
        itemList.add(ItemModel("Sticky Header 2", R.drawable.image_3, "Title 9", "unselected"))
        itemList.add(ItemModel("Sticky Header 2", R.drawable.image_4, "Title 10", "unselected"))
        itemList.add(ItemModel("Sticky Header 2", R.drawable.image_5, "Title 11", "unselected"))
        itemList.add(ItemModel("Sticky Header 2", R.drawable.image_6, "Title 12", "unselected"))

        // Create the adapter
        val userAdapter = UserAdapter(itemList)

        // Set the adapter to the StickyListHeadersListView
        binding.stickyListView.adapter = userAdapter
    }

}
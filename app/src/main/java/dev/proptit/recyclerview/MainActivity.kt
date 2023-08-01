package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemList = listOf(
            Item(R.drawable.image_1,"Title 1", "unselected"),
            Item(R.drawable.image_2,"Title 2", "unselected"),
            Item(R.drawable.image_3,"Title 3", "unselected"),
            Item(R.drawable.image_4,"Title 4", "unselected"),
            Item(R.drawable.image_5,"Title 5", "unselected"),
            Item(R.drawable.image_6,"Title 6", "unselected"),
            Item(R.drawable.image_1,"Title 7", "unselected"),
            Item(R.drawable.image_2,"Title 8", "unselected"),
            Item(R.drawable.image_3,"Title 9", "unselected"),
            Item(R.drawable.image_4,"Title 10", "unselected"),
            Item(R.drawable.image_5,"Title 11", "unselected"),
            Item(R.drawable.image_6,"Title 12", "unselected"),
        )

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.layoutManager = linearLayoutManager

        val adapter = UserAdapter(itemList)
        binding.recyclerView.adapter = adapter


        val userAdapter = UserAdapter(itemList)
        binding.recyclerView.adapter = userAdapter
    }

    override fun onItemClick(resourceId: Int) {

    }

}
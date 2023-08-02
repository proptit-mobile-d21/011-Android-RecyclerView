package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.Adapter.ItemAdapter
import dev.proptit.recyclerview.Listener.ItemListener
import dev.proptit.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val itemData = mutableListOf<Item>(
        Item(R.drawable.profile, "Title 1", "Unselected"),
        Item(R.drawable.profile, "Title 2", "Unselected"),
        Item(R.drawable.profile, "Title 3", "Unselected"),
        Item(R.drawable.profile, "Title 4", "Unselected"),
        Item(R.drawable.profile, "Title 5", "Unselected"),
        Item(R.drawable.profile, "Title 6", "Unselected"),
        Item(R.drawable.profile, "Title 7", "Unselected"),
        Item(R.drawable.profile, "Title 8", "Unselected"),
        Item(R.drawable.profile, "Title 9", "Unselected"),
        Item(R.drawable.profile, "Title 10", "Unselected"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ItemAdapter(itemData, object : ItemListener{
            override fun onItemClick(item : Item, position: Int) {
                Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClick(item : Item, position: Int) {

            }
        })
    }

}
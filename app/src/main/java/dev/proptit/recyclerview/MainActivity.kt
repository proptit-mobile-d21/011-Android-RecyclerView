package dev.proptit.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemRecyclerView: RecyclerView
    private lateinit var itemList: MutableList<Item>
    private lateinit var itemAdapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
    }

    private fun initComponent() {
        itemList = MutableList(10) {
                i->i+1
            Item("Title ${i+1}","unselected", R.drawable.avatar_svgrepo_com, false)
        }
        itemRecyclerView = binding.recyclerSelect
        itemRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        itemAdapter = ItemAdapter(itemList)
        itemRecyclerView.adapter = itemAdapter
    }
}
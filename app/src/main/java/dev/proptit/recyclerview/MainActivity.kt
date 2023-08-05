package dev.proptit.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemRecyclerView: RecyclerView

    private lateinit var itemAdapter: ItemAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initComponent()

        binding.listbutton.setOnClickListener {
            if(itemAdapter.usingGridLayout){
                itemRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                itemAdapter.usingGridLayout = false
                itemAdapter.notifyDataSetChanged()
            }
        }

        binding.gridbutton.setOnClickListener {
            if(!itemAdapter.usingGridLayout){
                val layout = GridLayoutManager(this, 3)
                layout.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
                    override fun getSpanSize(position: Int): Int {
                        return if(itemAdapter.getItemViewType(position) == ItemAdapter.DATA_HEADER)
                            layout.spanCount
                        else 1
                    }
                }
                itemRecyclerView.layoutManager= layout
                itemAdapter.usingGridLayout = true
                itemAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun initComponent() {
        val itemList = listOf<Data>(
            Header("Sticky Header 1"),
            Item("Title 1", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 2", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 3", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 4", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 5", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 6", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 7", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 8", "unselected", R.drawable.avatar_svgrepo_com, false),
            Header("Sticky Header 2"),
            Item("Title 9", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 10", "unselected", R.drawable.avatar_svgrepo_com, false),
            Item("Title 11", "unselected", R.drawable.avatar_svgrepo_com, false),
        )


        itemRecyclerView = binding.recyclerSelect
        itemRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        itemAdapter = ItemAdapter(itemList)
        itemRecyclerView.adapter = itemAdapter


    }



}
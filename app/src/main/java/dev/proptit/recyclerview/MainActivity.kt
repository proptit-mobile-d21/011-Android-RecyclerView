package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import dev.proptit.recyclerview.model.Item
import dev.proptit.recyclerview.model.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var itemList: MutableList<Item>
    private lateinit var rvItem: RecyclerView
    private lateinit var adapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
        setUpClickListener()


    }

    private fun setUpClickListener() {

    }

    fun initComponent(){
        itemList = MutableList(10) {
                i->i+1
            Item("Title ${i+1}","unseclected", R.drawable.ava_panda)
        }
        adapter = ItemAdapter(itemList)
        rvItem = binding.rvItemList

        rvItem.adapter = adapter
        rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}
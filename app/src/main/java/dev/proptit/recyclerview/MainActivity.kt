package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import dev.proptit.recyclerview.model.data.Item
import dev.proptit.recyclerview.model.adapter.ItemAdapter
import dev.proptit.recyclerview.model.adapter.ItemAdapter.Companion.FIRST_VIEW
import dev.proptit.recyclerview.model.adapter.ItemAdapter.Companion.SECOND_VIEW

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var itemList: MutableList<Item>
    private lateinit var rvItem: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var btnLinear: Button
    private lateinit var btnGrid: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
        setUpClickListener()


    }

    private fun setUpClickListener() {
        btnGrid.setOnClickListener{
            rvItem.layoutManager = GridLayoutManager(this, 3)
        }
        btnLinear.setOnClickListener{
            rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initComponent(){
        btnLinear = binding.btnList
        btnGrid = binding.btnGrid
        itemList = MutableList(50) {
            i->i+1
            if(i%3==0){
                Item(SECOND_VIEW, "Sticky Header ${i+1}",resources.getString(R.string.unselected), R.drawable.ava_panda, false)
            }else Item(FIRST_VIEW,"Title ${i+1}",resources.getString(R.string.unselected), R.drawable.ava_panda, false)
        }
        adapter = ItemAdapter(itemList)
        rvItem = binding.rvItemList

        rvItem.adapter = adapter
        rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}
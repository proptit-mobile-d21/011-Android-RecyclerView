package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import dev.proptit.recyclerview.model.Item
import dev.proptit.recyclerview.view.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        var itemList = mutableListOf(
//            Item("Title 1", R.drawable.ava_panda),
//            Item("Title 2", R.drawable.ava_panda),
//            Item("Title 3", R.drawable.ava_panda)
//        )
        var itemList = MutableList(10) {
            i->i+1
            Item("Title ${i+1}", R.drawable.ava_panda)
        }

        val adapter = ItemAdapter(itemList)
        binding.rvItemList.adapter = adapter
        binding.rvItemList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}
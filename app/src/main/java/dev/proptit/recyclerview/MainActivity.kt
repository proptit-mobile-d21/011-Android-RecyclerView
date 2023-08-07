package dev.proptit.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.proptit.recyclerview.adapter.Adapter
import dev.proptit.recyclerview.data.Data
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import dev.proptit.recyclerview.model.Item

class MainActivity : AppCompatActivity(), IListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            recyclerView.adapter = Adapter(Data.list, this@MainActivity)
            changeToListLayout()
            btnListLayout.setOnClickListener { changeToListLayout() }
            btnGridLayout.setOnClickListener { changeToGridLayout() }
        }
    }

    private fun changeToListLayout() {
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            (adapter as Adapter).isListLayout = true
        }
    }

    private fun changeToGridLayout() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when ((adapter as Adapter).getItemViewType(position)) {
                            Adapter.ITEM_GRID -> 1
                            else -> spanCount
                        }
                    }
                }
            }
            (adapter as Adapter).isListLayout = false
        }
    }

    override fun onClick(item: Item) {
        Toast.makeText(this, "${item.title} clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(item: Item, position: Int) {
        item.isSelected = !item.isSelected
        (binding.recyclerView.adapter as Adapter).notifyItemChanged(position)
        Toast.makeText(
            this,
            "${item.title} is ${if (item.isSelected) "selected" else "unselected"}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
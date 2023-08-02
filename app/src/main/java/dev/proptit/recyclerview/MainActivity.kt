package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.proptit.recyclerview.adapter.MyAdapter
import dev.proptit.recyclerview.data.Dataset
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import dev.proptit.recyclerview.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainRcv.layoutManager = LinearLayoutManager(applicationContext)
        binding.mainRcv.adapter = MyAdapter(Dataset.get()) { itemOnClick(it) }
    }

    private fun itemOnClick(item: Item) {
        Toast.makeText(applicationContext, "${item.title} clicked", Toast.LENGTH_SHORT).show()
    }
}
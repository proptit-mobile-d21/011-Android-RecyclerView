package dev.proptit.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dev.proptit.recyclerview.adapter.MyAdapter
import dev.proptit.recyclerview.data.Dataset
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import dev.proptit.recyclerview.model.IOptionListener
import dev.proptit.recyclerview.model.Option

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainRcv.layoutManager = LinearLayoutManager(applicationContext)
        binding.mainRcv.adapter = MyAdapter(Dataset.get(), object : IOptionListener {
            override fun onClick(option: Option) { optionOnClick(option) }

            override fun onLongClick(option: Option, position: Int) { optionOnLongClick(option, position) }
        })
    }

    private fun optionOnClick(option: Option) {
        Toast.makeText(applicationContext, "${option.title} clicked", Toast.LENGTH_SHORT).show()
    }

    private fun optionOnLongClick(option: Option, position: Int) {
        option.isSelected = !option.isSelected
        binding.mainRcv.adapter?.notifyItemChanged(position)
        Toast.makeText(
            applicationContext,
            "${option.title} " + if (option.isSelected) "selected" else "unselected",
            Toast.LENGTH_SHORT
        ).show()
    }
}
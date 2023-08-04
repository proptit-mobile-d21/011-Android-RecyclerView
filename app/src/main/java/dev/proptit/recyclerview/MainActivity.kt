package com.example.android_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_recyclerview.databinding.ActivityMainBinding
import com.example.android_recyclerview.model.Data
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerViewAdapter: RecyclerView
    private lateinit var mArrayList: ArrayList<Data>
    private lateinit var binding: ActivityMainBinding
    private lateinit var item: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onCreateItem()
        mRecyclerViewAdapter = findViewById(R.id.recyclerView)
        mRecyclerViewAdapter.layoutManager = LinearLayoutManager(this)

        mRecyclerViewAdapter.adapter = RecyclerViewAdapter(mArrayList)

    }

    private fun onCreateItem() {
        mArrayList =  ArrayList<Data>()
        for(i in 1..15){
            val newItem = Data("Cat $i",R.drawable.image_cat)
            mArrayList.add(newItem)
        }

    }

}
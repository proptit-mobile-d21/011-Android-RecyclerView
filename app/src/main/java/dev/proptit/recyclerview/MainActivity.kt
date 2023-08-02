package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dev.proptit.recyclerview.Adapter.ItemAdapter
import dev.proptit.recyclerview.Listener.ItemListener
import dev.proptit.recyclerview.databinding.ActivityMainBinding
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val itemData = mutableListOf(
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
                Toast.makeText(
                    this@MainActivity,
                    "${item.title} Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onItemLongClick(item : Item, position: Int) {
                item.isSelected = item.isSelected xor true
                binding.recyclerView.adapter?.notifyItemChanged(position)
                Toast.makeText(
                    this@MainActivity,
                    item.title + if(item.isSelected) " Selected" else " Unselected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

         setUpSwipeActions()

    }


    private fun setUpSwipeActions(){
        val touchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
//                    val fromPosition = viewHolder.adapterPosition
//                    val toPosition = target.adapterPosition
//                    Collections.swap(itemData, fromPosition, toPosition)
//                    binding.recyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    val item = itemData[position]
                    itemData.removeAt(position)
                    binding.recyclerView.adapter?.notifyItemRemoved(position)
                    val message = "${item.title} Deleted"
                    Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
                        .setAction("Undo") {
                            itemData.add(position, item)
                            binding.recyclerView.adapter?.notifyItemInserted(position)
                        }.show()
                }
            }
        )
        touchHelper.attachToRecyclerView(binding.recyclerView)
    }

}



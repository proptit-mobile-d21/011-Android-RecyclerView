package dev.proptit.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dev.proptit.recyclerview.Adapter.ItemAdapter
import dev.proptit.recyclerview.Listener.ItemListener
import dev.proptit.recyclerview.Model.Header
import dev.proptit.recyclerview.Model.Item
import dev.proptit.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val itemData = mutableListOf(
        Header("Sticky Header 1"),
        Item(R.drawable.profile, "Title 1", "Unselected"),
        Item(R.drawable.profile, "Title 2", "Unselected"),
        Item(R.drawable.profile, "Title 3", "Unselected"),
        Header("Sticky Header 2"),
        Item(R.drawable.profile, "Title 4", "Unselected"),
        Item(R.drawable.profile, "Title 5", "Unselected"),
        Item(R.drawable.profile, "Title 6", "Unselected"),
        Header("Sticky Header 3"),
        Item(R.drawable.profile, "Title 7", "Unselected"),
        Item(R.drawable.profile, "Title 8", "Unselected"),
        Item(R.drawable.profile, "Title 9", "Unselected"),
        Header("Sticky Header 4"),
        Item(R.drawable.profile, "Title 10", "Unselected"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButton();
        initRecyclerView()

         setUpSwipeActions()

    }
    private fun initButton(){
        binding.btnGrid.setOnClickListener{
            binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        binding.btnList.setOnClickListener{
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun initRecyclerView(){
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
    }
    private fun setUpSwipeActions(){
        val touchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                0,
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
                    val item = itemData[position] as Item
                    if(item is Item){
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
            }
        )
        touchHelper.attachToRecyclerView(binding.recyclerView)
    }

}



package dev.proptit.recyclerview

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.proptit.recyclerview.adapter.DemoAdapter
import dev.proptit.recyclerview.adapter.ItemClickCallback
import dev.proptit.recyclerview.adapter.LayoutType
import dev.proptit.recyclerview.databinding.ActivityDemoBinding
import dev.proptit.recyclerview.model.DemoItem

class DemoActivity : Activity() {
    private lateinit var mBinding: ActivityDemoBinding
    private lateinit var mDemoAdapter: DemoAdapter
    private var onItemClick: (String) -> Unit = {}
    private var onItemLongClick: (String, Boolean) -> Unit = { _, _ -> }

    private val mItems = mutableListOf<DemoItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupView()
        setupAction()
        setupData()
    }

    private fun setupView() {

    }

    private fun setupAction() {
        onItemClick = { title ->
            Toast.makeText(this, "$title clicked", Toast.LENGTH_SHORT).show()
        }

        onItemLongClick = { title, isSelected ->
            val action = if (isSelected)
                "selected"
            else
                "deselected"
            Toast.makeText(this, "$title $action", Toast.LENGTH_SHORT).show()
        }

        mBinding.apply {
            btnListLayout.setOnClickListener {
                changeLayout(LayoutType.LINEAR)
            }

            btnGridLayout.setOnClickListener {
                changeLayout(LayoutType.GRID)
            }
        }
    }

    private fun setupData() {
        mItems.addAll(
            listOf(
                DemoItem(title = "Sticky Header 1"),
                DemoItem(
                    R.drawable.im_1,
                    getString(R.string.title1),
                    getString(R.string.des1)
                ),
                DemoItem(
                    R.drawable.im_2,
                    getString(R.string.title2),
                    getString(R.string.des2)
                ),
                DemoItem(
                    R.drawable.im_3,
                    getString(R.string.title3),
                    getString(R.string.des3)
                ),
                DemoItem(
                    R.drawable.im_4,
                    getString(R.string.title4),
                    getString(R.string.des4)
                ),
                DemoItem(
                    R.drawable.im_5,
                    getString(R.string.title5),
                    getString(R.string.des5)
                ),
                DemoItem(
                    R.drawable.im_6,
                    getString(R.string.title6),
                    getString(R.string.des6)
                ),
                DemoItem(
                    R.drawable.im_7,
                    getString(R.string.title7),
                    getString(R.string.des7)
                ),
                DemoItem(
                    R.drawable.im_8,
                    getString(R.string.title8),
                    getString(R.string.des8)
                ),
                DemoItem(title = "Sticky Header 2"),
                DemoItem(
                    R.drawable.im_9,
                    getString(R.string.title9),
                    getString(R.string.des9)
                ),
                DemoItem(
                    R.drawable.im_10,
                    getString(R.string.title10),
                    getString(R.string.des10)
                ),
                DemoItem(title = "Sticky Header 3"),
                DemoItem(
                    R.drawable.im_11,
                    getString(R.string.title11),
                    getString(R.string.des11)
                )
            )
        )

        mDemoAdapter = DemoAdapter(object : ItemClickCallback {
            override fun onClick(title: String) {
                onItemClick(title)
            }

            override fun onLongClick(title: String, isSelected: Boolean) {
                onItemLongClick(title, isSelected)
            }
        })

        mBinding.rcItems.adapter = mDemoAdapter

        mDemoAdapter.updateData(mItems)
    }

    private fun changeLayout(layoutType: LayoutType) {
        mBinding.rcItems.layoutManager = when (layoutType) {
            LayoutType.LINEAR -> LinearLayoutManager(this)
            LayoutType.GRID -> {
                GridLayoutManager(this, 3)
            }
        }

        //make sticky header for grid layout
        if (layoutType == LayoutType.GRID) {
            val layoutManager = mBinding.rcItems.layoutManager as? GridLayoutManager
            layoutManager?.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (mDemoAdapter.getItemViewType(position) == -1)
                        (layoutManager?.spanCount ?: 3)
                    else 1
                }
            }
        }

        mDemoAdapter.updateLayout(layoutType)
    }
}

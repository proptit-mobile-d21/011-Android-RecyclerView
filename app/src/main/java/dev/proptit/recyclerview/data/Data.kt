package dev.proptit.recyclerview.data

import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.model.Category
import dev.proptit.recyclerview.model.Item

object Data {
    private val items_1 = listOf<Item>(
        Item(R.drawable.avatar, "Title 1"),
        Item(R.drawable.avatar, "Title 2"),
        Item(R.drawable.avatar, "Title 3"),
        Item(R.drawable.avatar, "Title 4"),
        Item(R.drawable.avatar, "Title 5"),
        Item(R.drawable.avatar, "Title 6"),
        Item(R.drawable.avatar, "Title 7"),
        Item(R.drawable.avatar, "Title 8")
    )
    private val items_2 = listOf<Item>(
        Item(R.drawable.avatar, "Title 9"),
        Item(R.drawable.avatar, "Title 10")
    )
    private val items_3 = listOf<Item>(
        Item(R.drawable.avatar, "Title 11")
    )
    val categories = listOf<Category>(
        Category("Sticky Header 1", items_1),
        Category("Sticky Header 2", items_2),
        Category("Sticky Header 3", items_3)
    )
}
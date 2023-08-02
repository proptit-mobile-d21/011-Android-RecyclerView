package dev.proptit.recyclerview.data

import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.model.Item

object Dataset {
    fun get(): List<Item> = listOf(
        Item("Title 1", R.drawable.ic_launcher_background),
        Item("Title 2", R.drawable.ic_launcher_background),
        Item("Title 3", R.drawable.ic_launcher_background),
        Item("Title 4", R.drawable.ic_launcher_background),
        Item("Title 5", R.drawable.ic_launcher_background),
        Item("Title 6", R.drawable.ic_launcher_background),
        Item("Title 7", R.drawable.ic_launcher_background),
        Item("Title 8", R.drawable.ic_launcher_background),
    )
}
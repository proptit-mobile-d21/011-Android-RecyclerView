package dev.proptit.recyclerview.data

import dev.proptit.recyclerview.R
import dev.proptit.recyclerview.model.Option

object Dataset {
    fun get(): List<Option> = listOf(
        Option("Title 1", R.drawable.ic_launcher_background),
        Option("Title 2", R.drawable.ic_launcher_background),
        Option("Title 3", R.drawable.ic_launcher_background),
        Option("Title 4", R.drawable.ic_launcher_background),
        Option("Title 5", R.drawable.ic_launcher_background),
        Option("Title 6", R.drawable.ic_launcher_background),
        Option("Title 7", R.drawable.ic_launcher_background),
        Option("Title 8", R.drawable.ic_launcher_background),
    )
}
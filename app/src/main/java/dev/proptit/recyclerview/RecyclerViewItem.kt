package dev.proptit.recyclerview

abstract class RecyclerViewItem {
}

class SectionItem(val title: String) : RecyclerViewItem()
class ContentItem(val title: String, val number: Int) : RecyclerViewItem()
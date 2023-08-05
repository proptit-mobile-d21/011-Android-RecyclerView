package dev.proptit.recyclerview.model.data

data class Item(
    var viewType: Int = 1,
    val title: String,
    val subtitle: String,
    val image: Int,
    private var state: Boolean
){
    fun setState(type: Boolean){
        state = type
    }
    fun getState(): Boolean{
        return state
    }
}
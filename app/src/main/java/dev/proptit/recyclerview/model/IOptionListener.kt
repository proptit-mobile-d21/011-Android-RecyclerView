package dev.proptit.recyclerview.model

interface IOptionListener {
    fun onClick(option: Option)
    fun onLongClick(option: Option, position: Int)
}
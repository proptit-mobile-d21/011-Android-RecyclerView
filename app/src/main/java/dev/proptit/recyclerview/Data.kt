package dev.proptit.recyclerview

data class DataItem(
    val imageResId: Int,
    val name: String,
    val description: String,
    var selected : Boolean
)
data class DataItemGrid(
    val imageResId: Int,
    val name: String,
)
object Team {
    private val myTeam = mutableListOf<DataItem>()
    fun getTeam() : List<DataItem> {
        return myTeam
    }
    fun addCharacter (character : DataItem){
        myTeam.add(character)
    }
    fun removeCharacter (character: DataItem){
        myTeam.removeIf{it.name == character.name}
    }
}

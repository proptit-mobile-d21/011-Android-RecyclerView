package dev.proptit.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

interface OnItemClickListener {
    fun onItemClick(item: DataItemGrid)
}
class ChooseActivity : AppCompatActivity(), OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewGrid)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        val data = listOf(
            DataItemGrid(R.mipmap.astral_express_foreground, "ASTRAL EXPRESS"),
            DataItemGrid(R.mipmap.herta_space_station_foreground, "HERTA SPACE STATION"),
            DataItemGrid(R.mipmap.belobog_foreground,"BELOBOG"),
            DataItemGrid(R.mipmap.xianzhou_the_loufu_foreground, "XIANZHOU : THE LOUFU"),
            DataItemGrid(R.mipmap.stellaron_hunter_foreground, "STELLARON HUNTER"),
            DataItemGrid(R.mipmap.team_foreground,"MY TEAM")
        )
        val adapter = GridViewAdapter(data,this)
        recyclerView.adapter = adapter
    }
    override fun onItemClick(item: DataItemGrid) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("choose", item.name)
        startActivity(intent)
    }
}
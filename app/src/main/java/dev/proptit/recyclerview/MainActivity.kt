package dev.proptit.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val intent = intent
        val choose = intent.getStringExtra("choose")
        when (choose) {
            "ASTRAL EXPRESS" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.astral_express_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "ASTRAL EXPRESS"
                val dataList = listOf(
                    DataItem(R.mipmap.himeko_foreground, "Himeko", "Erudition - Fire"),
                    DataItem(R.mipmap.welt_foreground, "Welt", "Nihility - Imaginary"),
                    DataItem(R.mipmap.trailblazer_foreground, "Trailblazer", "Destruction - Physical"),
                    DataItem(R.mipmap.dan_heng_foreground, "DanHeng", "The Hunt - Wind"),
                    DataItem(R.mipmap.march7th_foreground, "March 7th", "Preservation - Ice")
                )
                val adapter = CustomAdapter(dataList)
                recyclerView.adapter = adapter
            }
            "HERTA SPACE STATION" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.herta_space_station_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "HERTA SPACE STATION"
                val dataList = listOf(
                    DataItem(R.mipmap.herta_foreground, "Herta", "Erudition - Ice"),
                    DataItem(R.mipmap.welt_foreground, "Welt", "Destruction - Lightning"),
                    DataItem(R.mipmap.asta_foreground, "Asta", "Harmony - Fire")
                )
                val adapter = CustomAdapter(dataList)
                recyclerView.adapter = adapter
            }
            "BELOBOG" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.belobog_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "BELOBOG"
                val dataList = listOf(
                    DataItem(R.mipmap.gepard_foreground, "Gepard", "Preservation - Ice"),
                    DataItem(R.mipmap.bronya_foreground, "Bronya", "Harmony - Wind"),
                    DataItem(R.mipmap.seele_foreground, "Seele", "The Hunt - Quantum"),
                    DataItem(R.mipmap.clara_foreground, "Clara", "Destruction - Physical"),
                    DataItem(R.mipmap.natasha_foreground, "Natasha", "Abundance - Physical"),
                    DataItem(R.mipmap.pela_foreground, "Pela", "Nihility - Ice"),
                    DataItem(R.mipmap.serval_foreground, "Serval", "Erudition - Lightning"),
                    DataItem(R.mipmap.hook_foreground, "Hook", "Destruction - Fire"),
                    DataItem(R.mipmap.luka_foreground, "Luka", "Destruction - Physical"),
                    DataItem(R.mipmap.sampo_foreground, "Sampo", "Nihility - Wind")
                )
                val adapter = CustomAdapter(dataList)
                recyclerView.adapter = adapter
            }
            "XIANZHOU : THE LOUFU" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.xianzhou_the_loufu_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "XIANZHOU : THE LOUFU"
                val dataList = listOf(
                    DataItem(R.mipmap.jing_yuan_foreground, "Jing Yuan", "Erudition - Lightning"),
                    DataItem(R.mipmap.yanqing_foreground, "Yanqing", "The Hunt - Ice"),
                    DataItem(R.mipmap.loucha_foreground, "Loucha", "Abundance - Imaginary"),
                    DataItem(R.mipmap.bailu_foreground, "Bailu", "Abundance - Lightning"),
                    DataItem(R.mipmap.tingyun_foreground, "Tingyun", "Harmony - Lightning"),
                    DataItem(R.mipmap.pela_foreground, "Yukong", "Harmony - Imaginary"),
                    DataItem(R.mipmap.qingque_foreground, "Qingque", "Erudition - Quantum"),
                    DataItem(R.mipmap.sushang_foreground, "Sushang", "The Hunt - Physical")
                )
                val adapter = CustomAdapter(dataList)
                recyclerView.adapter = adapter
            }
            "STELLARON HUNTER" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.stellaron_hunter_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "STELLARON HUNTER"
                val dataList = listOf(
                    DataItem(R.mipmap.kafka_foreground, "Kafka", "Nihility - Lightning"),
                    DataItem(R.mipmap.blade_foreground, "Blade", "Destruction - Wind"),
                    DataItem(R.mipmap.silver_wolf_foreground, "Silver Wolf", "Nihility - Quantum")
                )
                val adapter = CustomAdapter(dataList)
                recyclerView.adapter = adapter
            }
            else -> {
                Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
            }
        }
        val backButton : ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            this.finish()
        }
    }
}
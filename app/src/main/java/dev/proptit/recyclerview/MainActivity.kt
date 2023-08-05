package dev.proptit.recyclerview


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.proptit.recyclerview.Team
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val intent = intent
        val context : Context = this
        val choose = intent.getStringExtra("choose")
        when (choose) {
            "ASTRAL EXPRESS" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.astral_express_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "ASTRAL EXPRESS"
                val dataList = listOf(
                    DataItem(R.mipmap.himeko_foreground, "Himeko",
                        "Erudition - Fire",false),
                    DataItem(R.mipmap.welt_foreground, "Welt",
                        "Nihility - Imaginary",false),
                    DataItem(R.mipmap.trailblazer_foreground, "Trailblazer",
                        "Destruction - Physical",false),
                    DataItem(R.mipmap.dan_heng_foreground, "DanHeng",
                        "The Hunt - Wind",false),
                    DataItem(R.mipmap.march7th_foreground, "March 7th",
                        "Preservation - Ice",false)
                )
                val adapter = CustomAdapter(context, dataList)
                recyclerView.adapter = adapter
            }
            "HERTA SPACE STATION" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.herta_space_station_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "HERTA SPACE STATION"
                val dataList = listOf(
                    DataItem(R.mipmap.herta_foreground, "Herta",
                        "Erudition - Ice",false),
                    DataItem(R.mipmap.arlan_foreground, "Arlan",
                        "Destruction - Lightning",false),
                    DataItem(R.mipmap.asta_foreground, "Asta",
                        "Harmony - Fire",false)
                )
                val adapter = CustomAdapter(context, dataList)
                recyclerView.adapter = adapter
            }
            "BELOBOG" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.belobog_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "BELOBOG"
                val dataList = listOf(
                    DataItem(R.mipmap.gepard_foreground, "Gepard",
                        "Preservation - Ice",false),
                    DataItem(R.mipmap.bronya_foreground, "Bronya",
                        "Harmony - Wind",false),
                    DataItem(R.mipmap.seele_foreground, "Seele",
                        "The Hunt - Quantum",false),
                    DataItem(R.mipmap.clara_foreground, "Clara",
                        "Destruction - Physical",false),
                    DataItem(R.mipmap.natasha_foreground, "Natasha",
                        "Abundance - Physical",false),
                    DataItem(R.mipmap.pela_foreground, "Pela",
                        "Nihility - Ice",false),
                    DataItem(R.mipmap.serval_foreground, "Serval",
                        "Erudition - Lightning",false),
                    DataItem(R.mipmap.hook_foreground, "Hook",
                        "Destruction - Fire",false),
                    DataItem(R.mipmap.luka_foreground, "Luka",
                        "Destruction - Physical",false),
                    DataItem(R.mipmap.sampo_foreground, "Sampo",
                        "Nihility - Wind",false)
                )
                val adapter = CustomAdapter(context, dataList)
                recyclerView.adapter = adapter
            }
            "XIANZHOU : THE LOUFU" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.xianzhou_the_loufu_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "XIANZHOU : THE LOUFU"
                val dataList = listOf(
                    DataItem(R.mipmap.jing_yuan_foreground, "Jing Yuan",
                        "Erudition - Lightning",false),
                    DataItem(R.mipmap.yanqing_foreground, "Yanqing",
                        "The Hunt - Ice",false),
                    DataItem(R.mipmap.loucha_foreground, "Loucha",
                        "Abundance - Imaginary",false),
                    DataItem(R.mipmap.bailu_foreground, "Bailu",
                        "Abundance - Lightning",false),
                    DataItem(R.mipmap.tingyun_foreground, "Tingyun",
                        "Harmony - Lightning",false),
                    DataItem(R.mipmap.pela_foreground, "Yukong",
                        "Harmony - Imaginary",false),
                    DataItem(R.mipmap.qingque_foreground, "Qingque",
                        "Erudition - Quantum",false),
                    DataItem(R.mipmap.sushang_foreground, "Sushang",
                        "The Hunt - Physical",false)
                )
                val adapter = CustomAdapter(context, dataList)
                recyclerView.adapter = adapter
            }
            "STELLARON HUNTER" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.stellaron_hunter_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "STELLARON HUNTER"
                val dataList = listOf(
                    DataItem(R.mipmap.kafka_foreground, "Kafka",
                        "Nihility - Lightning",false),
                    DataItem(R.mipmap.blade_foreground, "Blade",
                        "Destruction - Wind",false),
                    DataItem(R.mipmap.silver_wolf_foreground, "Silver Wolf",
                        "Nihility - Quantum",false)
                )
                val adapter = CustomAdapter(context, dataList)
                recyclerView.adapter = adapter
            }
            "MY TEAM" -> {
                val forceImage: ImageView = findViewById(R.id.force_image)
                forceImage.setImageResource(R.mipmap.team_foreground)
                val forceName: TextView = findViewById(R.id.force_name)
                forceName.text = "MY TEAM"
                val dataList = Team.getTeam()
                val adapter = CustomAdapter(context, dataList)
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
package com.bpsbanyumas.onetouchstatisticsbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.bpsbanyumas.onetouchstatisticsbanyumas.adapters.MainDataAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_item.*

class MainActivity : AppCompatActivity() {
    
    private val list = ArrayList<MainData>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        rv_maindata.setHasFixedSize(true)
        list.addAll(getListMainData())
        showRecyclerList()
    }

    fun getListMainData(): ArrayList<MainData> {

        val listMainData = ArrayList<MainData>()

        listMainData.add(MainData("Inflasi", "Sekian %", "ini Deskripsi", R.drawable.inflasi))
        listMainData.add(MainData("Kependudukan", "Sekian %", "ini Deskripsi", R.drawable.kependudukan))
        listMainData.add(MainData("Kemiskinan", "Sekian %", "ini Deskripsi", R.drawable.kemiskinan))
        listMainData.add(MainData("Ketenagakerjaan", "Sekian %", "ini Deskripsi", R.drawable.ketenagakerjaan))
        listMainData.add(MainData("IPM", "Sekian %", "ini Deskripsi", R.drawable.ipm))
        listMainData.add(MainData("Pertumbuhan", "Sekian %", "ini Deskripsi", R.drawable.pertumbuhan))

        return listMainData
    }

    private fun showRecyclerList() {
        rv_maindata.layoutManager = LinearLayoutManager(this)
        val listMyDataAdapter = MainDataAdapter(list, this@MainActivity)
        rv_maindata.adapter = listMyDataAdapter
    }
}
package com.bpsbanyumas.onetouchstatisticsbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.bpsbanyumas.onetouchstatisticsbanyumas.adapters.MainDataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    private val list = ArrayList<MainData>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        rv_maindata.setHasFixedSize(true)
        list.addAll(getListMainData())
        showRecyclerList()
    }

    fun getListMainData(): ArrayList<MainData> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataValue = resources.getStringArray(R.array.data_value)
        val dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)

        val listMainData = ArrayList<MainData>()

        for (position in dataJudul.indices) {
            val myData = MainData(
                dataJudul[position],
                dataValue[position],
                dataDeskripsi[position]
            )
            listMainData.add(myData)
        }
        return listMainData
    }

    private fun showRecyclerList() {
        rv_maindata.layoutManager = LinearLayoutManager(this)
        val listMyDataAdapter = MainDataAdapter(list, this@MainActivity)
        rv_maindata.adapter = listMyDataAdapter
    }
}
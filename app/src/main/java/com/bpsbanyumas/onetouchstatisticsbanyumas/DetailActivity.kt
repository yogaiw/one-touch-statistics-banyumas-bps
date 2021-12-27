package com.bpsbanyumas.onetouchstatisticsbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.bpsbanyumas.onetouchstatisticsbanyumas.adapters.MainDataAdapter
import ir.androidexception.datatable.model.DataTableHeader
import ir.androidexception.datatable.model.DataTableRow
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val posisi = intent.getStringExtra("POSISI")

        when(posisi) {
            "0" -> {
                setContentView(R.layout.activity_detail)
                showDataInflasi()
            }
            "1" -> setContentView(R.layout.detail_kependudukan)
            "2" -> setContentView(R.layout.detail_kemiskinan)
            "3" -> setContentView(R.layout.detail_ketenagakerjaan)
            "4" -> setContentView(R.layout.detail_ipm)
            "5" -> setContentView(R.layout.detail_pertumbuhan)
        }
    }

    fun showDataInflasi() {
        val data_bulan = arrayOf("Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus","September", "Oktober", "November", "Desember")
        val data_value = arrayOf("0.35","0.15","0.06","0.04","0.19","-0.20","0.09","0.12","-0.13","0.35","0.40","Belum Tersedia")

        val rows: ArrayList<DataTableRow> = ArrayList()

        val header = DataTableHeader.Builder()
            .item("Bulan",12)
            .item("Angka Inflasi (%)",12)
            .build()

        for(i in 0..11) {
            val row = DataTableRow.Builder()
                .value(data_bulan[i])
                .value(data_value[i])
                .build()
            rows.add(row)
        }

        data_inflasi.header = header
        data_inflasi.rows = rows
        data_inflasi.inflate(this)
    }
}
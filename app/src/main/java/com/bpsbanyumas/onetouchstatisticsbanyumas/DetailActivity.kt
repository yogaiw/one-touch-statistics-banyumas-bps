package com.bpsbanyumas.onetouchstatisticsbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.bpsbanyumas.onetouchstatisticsbanyumas.adapters.MainDataAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val posisi = intent.getStringExtra("POSISI")

        when(posisi) {
            "0" -> setContentView(R.layout.activity_detail)
            "1" -> setContentView(R.layout.detail_kependudukan)
            "2" -> setContentView(R.layout.detail_kemiskinan)
            "3" -> setContentView(R.layout.detail_ketenagakerjaan)
            "4" -> setContentView(R.layout.detail_ipm)
            "5" -> setContentView(R.layout.detail_pertumbuhan)
        }
    }
}
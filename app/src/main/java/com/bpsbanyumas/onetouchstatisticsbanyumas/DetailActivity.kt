package com.bpsbanyumas.onetouchstatisticsbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bpsbanyumas.onetouchstatisticsbanyumas.adapters.MainDataAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val posisi = intent.getStringExtra("POSISI")

        when(posisi) {
            "0" -> setContentView(R.layout.activity_detail)
            "1" -> setContentView(R.layout.detail_kependudukan)
        }
    }
}
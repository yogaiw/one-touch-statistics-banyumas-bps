package com.bpsbanyumas.onetouchstatisticsbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.bpsbanyumas.onetouchstatisticsbanyumas.adapters.MainDataAdapter
import com.bpsbanyumas.onetouchstatisticsbanyumas.databinding.DetailKemiskinanBinding
import ir.androidexception.datatable.DataTable
import ir.androidexception.datatable.model.DataTableHeader
import ir.androidexception.datatable.model.DataTableRow
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.detail_ipm.*
import kotlinx.android.synthetic.main.detail_kemiskinan.*
import kotlinx.android.synthetic.main.detail_kependudukan.*
import kotlinx.android.synthetic.main.detail_ketenagakerjaan.*
import kotlinx.android.synthetic.main.detail_pertumbuhan.*

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
            "1" -> {
                setContentView(R.layout.detail_kependudukan)
                showDataKependudukan()
            }
            "2" -> {
                setContentView(R.layout.detail_kemiskinan)
                showDataKemiskinan()
            }
            "3" -> {
                setContentView(R.layout.detail_ketenagakerjaan)
                showDataKetenagakerjaan()
            }
            "4" -> {
                setContentView(R.layout.detail_ipm)
                showDataIPM()
            }
            "5" -> {
                setContentView(R.layout.detail_pertumbuhan)
                showDataPDRB()
            }
        }
    }

    private fun showDataInflasi() {
        val data_bulan = arrayOf("Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus","September", "Oktober", "November", "Desember")
        val data_value = arrayOf("0,35","0,15","0,06","0,04","0,19","-0,20","0,09","0,12","-0,13","0,35","0,40","Belum Tersedia")

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

    private fun showDataPDRB() {
        val sektor = arrayOf("PDRB","Pertanian, Kehuatan, Perikanan","Pertambangan","Pengadaan Listrik dan Gas")
        val thn2019 = arrayOf("53.948.860","6.470.099","2.983.607","49.744")
        val thn2020 = arrayOf("53.682.118","6.681.389","2.990.219","50.696")

        val rows: ArrayList<DataTableRow> = ArrayList()

        val header = DataTableHeader.Builder()
            .item("Sektor PDRB",2)
            .item("2019",1)
            .item("2020",1)
            .build()

        for(i in 0..3) {
            val row = DataTableRow.Builder()
                .value(sektor[i])
                .value(thn2019[i])
                .value(thn2020[i])
                .build()
            rows.add(row)
        }

        data_pertumbuhan.header = header
        data_pertumbuhan.rows = rows
        data_pertumbuhan.inflate(this)
    }

    private fun showDataIPM() {
        val komponen = arrayOf("Angka Harapan Hidup (tahun)","Harapan Lama Sekolah (tahun)","Rata-Rata Lama Sekolah (tahun)","Pengeluaran Per Kapita","IPM")
        val thn2019 = arrayOf("73,55","12,82","7,42","Rp11.703","71,96")
        val thn2020 = arrayOf("73,72","12,85","7,52","Rp11.448","71,98")

        val rows: ArrayList<DataTableRow> = ArrayList()

        val header = DataTableHeader.Builder()
            .item("Komponen",2)
            .item("2019",1)
            .item("2020",1)
            .build()

        for(i in 0..4) {
            val row = DataTableRow.Builder()
                .value(komponen[i])
                .value(thn2019[i])
                .value(thn2020[i])
                .build()
            rows.add(row)
        }

        data_ipm.header = header
        data_ipm.rows = rows
        data_ipm.inflate(this)
    }

    private fun showDataKetenagakerjaan() {
        val bulan = arrayOf("Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","November","Desember")
        val thn2019 = arrayOf("1.750.000","1.750.000","1.750.000","1.750.000","1.750.000","1.750.000","1.750.000","1.750.000","1.750.000","1.750.000","1.750.000","1.750.000")
        val thn2020 = arrayOf("1.900.000","1.900.000","1.900.000","1.900.000","1.900.000","1.900.000","1.900.000","1.900.000","1.900.000","1.900.000","1.900.000","1.900.000")

        val rows: ArrayList<DataTableRow> = ArrayList()

        val header = DataTableHeader.Builder()
            .item("Bulan",1)
            .item("2019",1)
            .item("2020",1)
            .build()

        for(i in 0..11) {
            val row = DataTableRow.Builder()
                .value(bulan[i])
                .value(thn2019[i])
                .value(thn2020[i])
                .build()
            rows.add(row)
        }

        data_ketenagakerjaan.header = header
        data_ketenagakerjaan.rows = rows
        data_ketenagakerjaan.inflate(this)
    }

    private fun showDataKemiskinan() {
        val variabel = arrayOf("Jumlah Penduduk Miskin (ribu jiwa)","Persentase Penduduk Miskin","Garis Kemiskinan")
        val thn2019 = arrayOf("13,50","12,53 %","Rp385.140 /Kapita/Bulan")
        val thn2020 = arrayOf("225,84","13,26 %","Rp406.250 /Kapita/bulan")

        val rows:ArrayList<DataTableRow> = ArrayList()

        val header = DataTableHeader.Builder()
            .item("Kemiskinan", 2)
            .item("2019",1)
            .item("2020",1)
            .build()

        for(i in 0..2) {
            val row = DataTableRow.Builder()
                .value(variabel[i])
                .value(thn2019[i])
                .value(thn2020[i])
                .build()
            rows.add(row)
        }

        data_kemiskinan.header = header
        data_kemiskinan.rows = rows
        data_kemiskinan.inflate(this)
    }

    private fun showDataKependudukan() {
        val kecamatan = arrayOf(
            "Lumbir","Wangon","Jatilawang","Rawalo","Kebasen","Kemrajnen","Sumpiuh","Tambak","Somagede","Kalibagor",
            "Banyumas","Patikraja","Purwojati","Ajibarang","Gumelar","Pekuncen","Cilongok","Karanglewas","Kedungbanteng","Baturraden",
            "Sumbang","Kembaran","Sokaraja","Purwokerto Selatan","Purwokerto Barat","Purwokerto Timur","Purwokerto Utara")
        val penduduk = arrayOf(
            "49.870","83.695","66.431","52.847","67.140","72.383","57.717","50.158","37.540","56.800",
            "52.878","60.637","36.981","102.326","53.349","75.576","124.684","67.269","61.771","53.514",
            "93.160","81.737","89.184","72.304","52.802","54.585","49.580")
        val growth = arrayOf(
            "1,37","1,33","1,48","1,51","1,82","1,45","1,44","1,75","1,61","2,07",
            "1,44","1,81","1,78","1,26","1,63","1,56","1,32","1,58","1,85","1,23",
            "2,17","1,21","1,44","0,24","0,71","-0,44","-1,38")

        val rows: ArrayList<DataTableRow> = ArrayList()
        val header = DataTableHeader.Builder()
            .item("Kecamatan", 2)
            .item("Penduduk", 2)
            .item("Laju Pertumbuhan", 1)
            .build()

        for(i in 0..26) {
            val row = DataTableRow.Builder()
                .value(kecamatan[i])
                .value(penduduk[i])
                .value(growth[i])
                .build()
            rows.add(row)
        }

        data_kependudukan.header = header
        data_kependudukan.rows = rows
        data_kependudukan.inflate(this)
    }
}
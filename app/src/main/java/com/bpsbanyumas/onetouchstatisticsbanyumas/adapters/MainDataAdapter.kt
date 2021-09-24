package com.bpsbanyumas.onetouchstatisticsbanyumas.adapters

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bpsbanyumas.onetouchstatisticsbanyumas.MainData
import com.bpsbanyumas.onetouchstatisticsbanyumas.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.card_item.view.*

class MainDataAdapter(private val listMyData: ArrayList<MainData>, val context: Context) : RecyclerView.Adapter<MainDataAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])

        val myData = listMyData[position]

        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: MainData) {
            with(itemView){
                Glide.with(itemView.context).load(myData.icon).apply(RequestOptions().override(500, 500)).into(iv_icon)
                tv_judul.text = myData.judul
                tv_value.text = myData.value
                tv_deskripsi.text = myData.deskripsi
            }
        }
    }
}
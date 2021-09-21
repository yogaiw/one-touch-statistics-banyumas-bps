package com.bpsbanyumas.onetouchstatisticsbanyumas.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bpsbanyumas.onetouchstatisticsbanyumas.MainData
import com.bpsbanyumas.onetouchstatisticsbanyumas.R

class MainDataAdapter(private val listMyDatas: ArrayList<MainData>, val context: Context) : RecyclerView.Adapter<MainDataAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewViewHolder(view)
    }
    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val mainData = listMyDatas[position]

        holder.tvJudul.text = mainData.judul
        holder.tvValue.text = mainData.value
        holder.tvDeskripsi.text = mainData.deskripsi

    }

    override fun getItemCount(): Int {
        return listMyDatas.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvJudul: TextView = itemView.findViewById(R.id.tv_judul)
        var tvValue: TextView = itemView.findViewById(R.id.tv_value)
        var tvDeskripsi: TextView = itemView.findViewById(R.id.tv_deskripsi)
    }
}
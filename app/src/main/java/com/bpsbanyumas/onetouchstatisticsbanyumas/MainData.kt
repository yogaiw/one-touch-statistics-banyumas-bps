package com.bpsbanyumas.onetouchstatisticsbanyumas

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainData(
    var judul: String,
    var value: String,
    var deskripsi: String,
    var icon: Int ):Parcelable
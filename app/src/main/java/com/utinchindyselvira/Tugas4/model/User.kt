package com.utinchindyselvira.Tugas4.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val produk : String,
    val harga : String,
    val stok : String,
    val deskripsi : String
    ) : Parcelable
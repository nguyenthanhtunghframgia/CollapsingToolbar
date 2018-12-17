package com.example.framgianguyenthanhtungh.collapsingtoolbar.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val id: Int? = null,
    val name: String? = null
) : Parcelable

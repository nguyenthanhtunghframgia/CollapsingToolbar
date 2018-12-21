package com.example.framgianguyenthanhtungh.collapsingtoolbar.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.TB_WEATHER
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TB_WEATHER)
data class Weather(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String? = null
) : Parcelable

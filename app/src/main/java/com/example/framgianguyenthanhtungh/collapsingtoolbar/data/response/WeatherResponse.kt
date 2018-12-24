package com.example.framgianguyenthanhtungh.collapsingtoolbar.data.response

import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.model.Weather
import com.google.gson.annotations.SerializedName

open class WeatherResponse(
    @SerializedName("city") val weather: Weather? = null
)

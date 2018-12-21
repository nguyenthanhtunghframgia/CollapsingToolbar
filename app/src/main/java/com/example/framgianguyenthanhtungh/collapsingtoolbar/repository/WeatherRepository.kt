package com.example.framgianguyenthanhtungh.collapsingtoolbar.repository

import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.response.WeatherResponse
import io.reactivex.Single

interface WeatherRepository {
    fun getWeatherByLocation(location: String): Single<WeatherResponse>
}

package com.example.framgianguyenthanhtungh.collapsingtoolbar.data

import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.api.WeatherApi
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.response.WeatherResponse
import com.example.framgianguyenthanhtungh.collapsingtoolbar.repository.WeatherRepository
import io.reactivex.Single

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override fun getWeatherByLocation(location: String): Single<WeatherResponse> =
        weatherApi.getWeatherByLocation(location = location)
}

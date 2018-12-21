package com.example.framgianguyenthanhtungh.collapsingtoolbar.data.api

import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.response.WeatherResponse
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.API_QUERY_PARAM
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.API_WEATHER_PARAM
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(API_WEATHER_PARAM)
    fun getWeatherByLocation(@Query(API_QUERY_PARAM) location: String): Single<WeatherResponse>
}

package com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.weather

import androidx.lifecycle.MutableLiveData
import com.example.framgianguyenthanhtungh.collapsingtoolbar.base.BaseViewModel
import com.example.framgianguyenthanhtungh.collapsingtoolbar.model.Weather

class WeatherViewModel : BaseViewModel() {
    val listWeather = MutableLiveData<List<Weather>>()

    fun getData() {
        listWeather.postValue(
            listOf(
                Weather(1, "Halo1"),
                Weather(2, "Halo2"),
                Weather(3, "Halo3"),
                Weather(4, "Halo4"),
                Weather(5, "Halo5"),
                Weather(6, "Halo6"),
                Weather(7, "Halo7"),
                Weather(8, "Halo8"),
                Weather(9, "Halo9"),
                Weather(10, "Halo10")
            )
        )
    }
}

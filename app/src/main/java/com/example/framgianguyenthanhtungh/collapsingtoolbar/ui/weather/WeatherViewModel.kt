package com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.weather

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.framgianguyenthanhtungh.collapsingtoolbar.base.BaseViewModel
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.model.Weather
import com.example.framgianguyenthanhtungh.collapsingtoolbar.repository.WeatherRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(
    private val weatherRepository: WeatherRepository
) : BaseViewModel() {
    val listWeather = MutableLiveData<Weather>()
    val errorMessage = MutableLiveData<String>()

    @SuppressLint("CheckResult")
    fun getData() {
        weatherRepository.getWeatherByLocation("London")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listWeather.value = it.weather ?: return@subscribe
            }, {
                errorMessage.value = it.message
            })
    }
}

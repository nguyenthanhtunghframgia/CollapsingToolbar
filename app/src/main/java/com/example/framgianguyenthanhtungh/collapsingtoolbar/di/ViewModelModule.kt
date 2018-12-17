package com.example.framgianguyenthanhtungh.collapsingtoolbar.di

import com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.main.MainViewModel
import com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.weather.WeatherViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel<MainViewModel>()
    viewModel<WeatherViewModel>()
}

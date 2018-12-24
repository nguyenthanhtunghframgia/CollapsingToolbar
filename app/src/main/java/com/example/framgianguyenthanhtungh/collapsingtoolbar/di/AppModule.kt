package com.example.framgianguyenthanhtungh.collapsingtoolbar.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module {
    single { androidApplication().resources }
}

val modules = listOf(
    appModule,
    dataModule,
    viewModelModule
)

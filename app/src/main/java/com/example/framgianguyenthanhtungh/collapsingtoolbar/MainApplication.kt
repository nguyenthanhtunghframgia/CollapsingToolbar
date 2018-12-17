package com.example.framgianguyenthanhtungh.collapsingtoolbar

import android.app.Application
import com.example.framgianguyenthanhtungh.collapsingtoolbar.di.modules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}

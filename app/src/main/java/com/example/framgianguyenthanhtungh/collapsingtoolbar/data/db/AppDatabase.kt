package com.example.framgianguyenthanhtungh.collapsingtoolbar.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.dao.WeatherDao
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.model.Weather
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.DB_VERSION

@Database(entities = [Weather::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}

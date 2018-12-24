package com.example.framgianguyenthanhtungh.collapsingtoolbar.di

import android.content.Context
import androidx.room.Room
import com.example.framgianguyenthanhtungh.collapsingtoolbar.BuildConfig
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.WeatherRepositoryImpl
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.api.WeatherApi
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.db.AppDatabase
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.pref.PrefHelper
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.pref.PrefHelperImpl
import com.example.framgianguyenthanhtungh.collapsingtoolbar.repository.WeatherRepository
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.API_KEY_PARAM
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.AppExecutors
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.DB_NAME
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.TIME_OUT
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module(override = true) {

    //Create appExecutor
    single { createAppExecutor() }

    //Create app database
    single { createAppDatabase(get()) }

    //Create Dao
    single { createWeatherDao(get()) }

    //Create shared pref
    single { createSharedPreference(get()) }

    //Create weatherApi
    single { createHeaderInterceptor() }
    single { createOkHttp(get()) }
    single { createWeatherApi(get()) }

    //Repository
    single { createWeatherRepository(get()) }
}

fun createAppExecutor(): AppExecutors = AppExecutors()

fun createAppDatabase(context: Context) =
    Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
        .build()

fun createWeatherDao(appDatabase: AppDatabase) = appDatabase.weatherDao()

fun createSharedPreference(context: Context): PrefHelper = PrefHelperImpl(context)


private fun createHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        val original = chain.request()
        val newUrl = original.url().newBuilder()
            .addQueryParameter(API_KEY_PARAM, BuildConfig.API_KEY)
            .build()
        val requestBuilder = original.newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(requestBuilder)
    }
}

fun createOkHttp(header: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
        .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
        .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
        .addInterceptor(header)
    return builder.build()
}

fun createWeatherApi(okHttpClient: OkHttpClient): WeatherApi = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(WeatherApi::class.java)

fun createWeatherRepository(weatherApi: WeatherApi) : WeatherRepository = WeatherRepositoryImpl(weatherApi)

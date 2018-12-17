package com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.framgianguyenthanhtungh.collapsingtoolbar.R
import com.example.framgianguyenthanhtungh.collapsingtoolbar.base.BaseRecyclerAdapter
import com.example.framgianguyenthanhtungh.collapsingtoolbar.databinding.ItemWeatherBinding
import com.example.framgianguyenthanhtungh.collapsingtoolbar.model.Weather

class WeatherAdapter(val onItemClick: (Weather) -> Unit) : BaseRecyclerAdapter<Weather>(

    object : DiffUtil.ItemCallback<Weather>() {

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.id == newItem.id
        }
    }
) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ItemWeatherBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_weather, parent, false
        ).apply {
            root.setOnClickListener {
                this.itemWeather?.let { weather ->
                    onItemClick.invoke(weather)
                }
            }
        }
    }

    override fun bind(binding: ViewDataBinding, item: Weather) {
        if (binding is ItemWeatherBinding) binding.itemWeather = item
    }
}

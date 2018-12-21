package com.example.framgianguyenthanhtungh.collapsingtoolbar.ui.weather

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.framgianguyenthanhtungh.collapsingtoolbar.BR
import com.example.framgianguyenthanhtungh.collapsingtoolbar.R
import com.example.framgianguyenthanhtungh.collapsingtoolbar.base.BaseFragment
import com.example.framgianguyenthanhtungh.collapsingtoolbar.base.RecyclerItemDecoration
import com.example.framgianguyenthanhtungh.collapsingtoolbar.data.model.Weather
import com.example.framgianguyenthanhtungh.collapsingtoolbar.databinding.FragmentWeatherBinding
import com.example.framgianguyenthanhtungh.collapsingtoolbar.util.ITEM_DECORATION
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherFragment : BaseFragment<FragmentWeatherBinding, WeatherViewModel>() {

    override val viewModel by viewModel<WeatherViewModel>()

    override val layoutId: Int = R.layout.fragment_weather

    override val bindingVariable: Int = BR.weatherViewModel

    override fun initView(viewBinding: FragmentWeatherBinding) {

        val weatherAdapter = WeatherAdapter(
            onItemClick = {
                doClick(it)
            }
        )

        val decoration = RecyclerItemDecoration(ITEM_DECORATION)

        viewBinding.apply {
            recyclerWeather.apply {
                adapter = weatherAdapter
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(decoration)
            }
        }

        viewModel.apply {
            listWeather.observe(viewLifecycleOwner, Observer {
                weatherAdapter.submitList(listOf(it))
            })

            errorMessage.observe(viewLifecycleOwner, Observer {
                Toast.makeText(context, errorMessage.toString(), Toast.LENGTH_LONG).show()
            })

            getData()
        }
    }

    private fun doClick(weather: Weather) {
        Toast.makeText(context, weather.name, Toast.LENGTH_LONG).show()
    }
}

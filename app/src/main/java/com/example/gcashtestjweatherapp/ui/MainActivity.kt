package com.example.gcashtestjweatherapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.gcashtestjweatherapp.R
import com.example.gcashtestjweatherapp.viewmodel.WeatherViewModel
import com.example.gcashtestjweatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        @Suppress("UNUSED VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel.weatherResponse.observe(this) { weather ->

//            binding.apply {
//                tvCityName.text = "Luanda"
//                tvDescription.text = weather.description
//                tvTemperature.text = weather.temperature
//                tvWind.text = weather.wind
//
//                val forecast = weather.forecast
//                tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
//                tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
//                tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"
//
//            }

        }
    }
}
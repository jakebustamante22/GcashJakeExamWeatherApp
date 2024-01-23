package com.example.gcashtestjweatherapp.repository

import com.example.gcashtestjweatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getWeather() = apiService.getWeather()
}
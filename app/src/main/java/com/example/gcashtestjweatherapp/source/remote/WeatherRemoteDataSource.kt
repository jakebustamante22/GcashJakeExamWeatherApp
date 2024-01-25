package com.example.gcashtestjweatherapp.source.remote

import com.example.gcashtestjweatherapp.model.LocationModel
import com.example.gcashtestjweatherapp.model.NetworkWeather
import com.example.gcashtestjweatherapp.model.NetworkWeatherForecast
import com.example.gcashtestjweatherapp.utils.Result


interface WeatherRemoteDataSource {
    suspend fun getWeather(location: LocationModel): Result<NetworkWeather>

    suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>>

    suspend fun getSearchWeather(query: String): Result<NetworkWeather>
}

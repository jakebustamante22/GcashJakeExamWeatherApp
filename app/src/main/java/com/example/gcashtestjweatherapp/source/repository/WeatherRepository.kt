package com.example.gcashtestjweatherapp.source.repository

import com.example.gcashtestjweatherapp.model.LocationModel
import com.example.gcashtestjweatherapp.model.Weather
import com.example.gcashtestjweatherapp.model.WeatherForecast
import com.example.gcashtestjweatherapp.utils.Result


interface WeatherRepository {

    suspend fun getWeather(location: LocationModel, refresh: Boolean): Result<Weather?>

    suspend fun getForecastWeather(cityId: Int, refresh: Boolean): Result<List<WeatherForecast>?>

    suspend fun getSearchWeather(location: String): Result<Weather?>

    suspend fun storeWeatherData(weather: Weather)

    suspend fun storeForecastData(forecasts: List<WeatherForecast>)

    suspend fun deleteWeatherData()

    suspend fun deleteForecastData()
}

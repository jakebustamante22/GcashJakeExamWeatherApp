package com.example.gcashtestjweatherapp.model

data class WeatherForecast(
    val uID: Int,

    var date: String,

    val wind: Wind,

    val networkWeatherDescription: List<NetworkWeatherDescription>,

    val networkWeatherCondition: NetworkWeatherCondition
)

package com.example.gcashtestjweatherapp.model



data class Weather1(
    val description: String,
    val forecast: List<Forecast>,
    val temperature: String,
    val wind: String
)
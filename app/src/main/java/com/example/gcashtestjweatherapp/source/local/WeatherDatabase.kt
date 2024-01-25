package com.example.gcashtestjweatherapp.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gcashtestjweatherapp.source.local.dao.WeatherDao
import com.example.gcashtestjweatherapp.source.local.entity.DBWeather
import com.example.gcashtestjweatherapp.source.local.entity.DBWeatherForecast
import com.example.gcashtestjweatherapp.utils.typeconverters.ListNetworkWeatherDescriptionConverter

@Database(entities = [DBWeather::class, DBWeatherForecast::class], version = 1, exportSchema = true)
@TypeConverters(
    ListNetworkWeatherDescriptionConverter::class
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract val weatherDao: WeatherDao
}

package com.example.gcashtestjweatherapp.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gcashtestjweatherapp.model.NetworkWeatherCondition
import com.example.gcashtestjweatherapp.model.NetworkWeatherDescription
import com.example.gcashtestjweatherapp.model.Wind

/**
 * Created by Mayokun Adeniyi on 2020-01-28.
 */

@Entity(tableName = "weather_forecast")
class DBWeatherForecast(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val date: String,

    @Embedded
    val wind: Wind,

    @ColumnInfo(name = "weather_description")
    val networkWeatherDescriptions: List<NetworkWeatherDescription>,

    @Embedded
    val networkWeatherCondition: NetworkWeatherCondition
)

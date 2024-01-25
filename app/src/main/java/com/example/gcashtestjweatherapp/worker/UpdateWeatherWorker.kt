package com.example.gcashtestjweatherapp.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.gcashtestjweatherapp.source.repository.WeatherRepository
import com.example.gcashtestjweatherapp.utils.NotificationHelper
import com.example.gcashtestjweatherapp.utils.SharedPreferenceHelper
import com.example.gcashtestjweatherapp.utils.Result.Success


class UpdateWeatherWorker(
    context: Context,
    params: WorkerParameters,
    private val repository: WeatherRepository
) : CoroutineWorker(context, params) {
    private val notificationHelper = NotificationHelper("Weather Update", context)
    private val sharedPrefs = SharedPreferenceHelper.getInstance(context)

    override suspend fun doWork(): Result {
        val location = sharedPrefs.getLocation()
        return when (val result = repository.getWeather(location, true)) {
            is Success -> {
                if (result.data != null) {
                    when (
                        val foreResult =
                            repository.getForecastWeather(result.data.cityId, true)
                    ) {
                        is Success -> {
                            if (foreResult.data != null) {
                                notificationHelper.createNotification()
                                Result.success()
                            } else {
                                Result.failure()
                            }
                        }
                        else -> Result.failure()
                    }
                } else {
                    Result.failure()
                }
            }
            else -> Result.failure()
        }
    }
}

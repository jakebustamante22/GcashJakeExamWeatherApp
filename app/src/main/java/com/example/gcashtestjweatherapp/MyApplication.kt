package com.example.gcashtestjweatherapp

import android.app.Application
import android.util.Log
import androidx.preference.PreferenceManager
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import com.example.gcashtestjweatherapp.source.repository.WeatherRepository
import com.example.gcashtestjweatherapp.utils.ThemeManager
import com.example.gcashtestjweatherapp.worker.MyWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MyApplication() : Application() {

    @Inject
    lateinit var weatherRepository: WeatherRepository

    override fun onCreate() {
        super.onCreate()
        initTheme()
    }

    private fun initTheme() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        runCatching {
            ThemeManager.applyTheme(requireNotNull(preferences.getString("theme_key", "")))
        }.onFailure { exception ->
            Timber.e("Theme Manager: $exception")
        }
    }


}

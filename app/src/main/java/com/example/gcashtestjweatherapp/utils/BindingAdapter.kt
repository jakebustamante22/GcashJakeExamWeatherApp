package com.example.gcashtestjweatherapp.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.gcashtestjweatherapp.R
import com.github.pwittchen.weathericonview.WeatherIconView


/**
 * This function helps to dynamically set the icon for the [WeatherIconView]
 * @see WeatherIconGenerator
 */
@BindingAdapter("setIcon")
fun WeatherIconView.showIcon(condition: String?) {
    val context = this.context
    WeatherIconGenerator.getIconResources(context, this, condition)
}

@BindingAdapter("setTemperature")
fun TextView.setTemperature(double: Double) {
    val context = this.context
    if (SharedPreferenceHelper.getInstance(context).getSelectedTemperatureUnit() == context.getString(
            R.string.temp_unit_fahrenheit
        )
    )
        this.text = double.toString() + context.resources.getString(R.string.temp_symbol_fahrenheit)
    else
        this.text = double.toString() + context.resources.getString(R.string.temp_symbol_celsius)
}

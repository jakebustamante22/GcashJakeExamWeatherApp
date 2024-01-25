package com.example.gcashtestjweatherapp.ui.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gcashtestjweatherapp.model.LocationModel
import com.example.gcashtestjweatherapp.model.Weather
import com.example.gcashtestjweatherapp.source.repository.WeatherRepository
import com.example.gcashtestjweatherapp.utils.LocationLiveData
import com.example.gcashtestjweatherapp.utils.asLiveData
import com.example.gcashtestjweatherapp.utils.Result
import com.example.gcashtestjweatherapp.utils.convertKelvinToCelsius
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject


class HomeFragmentViewModel @Inject constructor(
    private val repository: WeatherRepository
) :
    ViewModel() {

    @Inject
    lateinit var locationLiveData: LocationLiveData

    init {
        currentSystemTime()
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading.asLiveData()

    private val _dataFetchState = MutableLiveData<Boolean>()
    val dataFetchState = _dataFetchState.asLiveData()

    private val _weather = MutableLiveData<Weather?>()
    val weather = _weather.asLiveData()

    val time = currentSystemTime()

    fun fetchLocationLiveData() = locationLiveData

    private val _navigatetoforeCastList = MutableLiveData<Boolean>()

    val navigatetoforeCastList: LiveData<Boolean>
        get() = _navigatetoforeCastList


    /**
     *This attempts to get the [Weather] from the local data source,
     * if the result is null, it gets from the remote source.
     * @see refreshWeather
     */
    fun getWeather(location: LocationModel) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            when (val result = repository.getWeather(location, false)) {
                is Result.Success -> {
                    _isLoading.value = false
                    if (result.data != null) {
                        val weather = result.data
                        _dataFetchState.value = true
                        _weather.value = weather
                    } else {
                        refreshWeather(location)
                    }
                }
                is Result.Error -> {
                    _isLoading.value = false
                    _dataFetchState.value = false
                }

                is Result.Loading -> _isLoading.postValue(true)
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun currentSystemTime(): String {
        val currentTime = System.currentTimeMillis()
        val date = Date(currentTime)
        val dateFormat = SimpleDateFormat("EEEE MMM d, hh:mm aaa")
        return dateFormat.format(date)
    }

    /**
     * This is called when the user swipes down to refresh.
     * This enables the [Weather] for the current [location] to be received.
     */
    fun refreshWeather(location: LocationModel) {
        _isLoading.value = true
        viewModelScope.launch {
            when (val result = repository.getWeather(location, true)) {
                is Result.Success -> {
                    _isLoading.value = false
                    if (result.data != null) {
                        val weather = result.data.apply {
                            this.networkWeatherCondition.temp = convertKelvinToCelsius(this.networkWeatherCondition.temp)
                        }
                        _dataFetchState.value = true
                        _weather.value = weather

                        repository.deleteWeatherData()
                        repository.storeWeatherData(weather)
                    } else {
                        _weather.postValue(null)
                        _dataFetchState.postValue(false)
                    }
                }
                is Result.Error -> {
                    _isLoading.value = false
                    _dataFetchState.value = false
                }
                is Result.Loading -> _isLoading.postValue(true)
            }
        }
    }
    fun goToForecastList() {
        _navigatetoforeCastList.value = false
    }

}

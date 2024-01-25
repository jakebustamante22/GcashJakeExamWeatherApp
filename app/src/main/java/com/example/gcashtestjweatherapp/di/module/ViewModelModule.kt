package com.example.gcashtestjweatherapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gcashtestjweatherapp.di.key.ViewModelKey
import com.example.gcashtestjweatherapp.ui.forecast.ForecastFragmentViewModel
import com.example.gcashtestjweatherapp.ui.home.HomeFragmentViewModel
import com.example.gcashtestjweatherapp.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap


@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun bindHomeFragmentViewModel(viewModel: HomeFragmentViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(ForecastFragmentViewModel::class)
    abstract fun bindForecastFragmentViewModel(viewModel: ForecastFragmentViewModel): ViewModel

}

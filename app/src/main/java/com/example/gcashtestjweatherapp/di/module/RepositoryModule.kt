package com.example.gcashtestjweatherapp.di.module

import com.example.gcashtestjweatherapp.source.repository.WeatherRepository
import com.example.gcashtestjweatherapp.source.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}

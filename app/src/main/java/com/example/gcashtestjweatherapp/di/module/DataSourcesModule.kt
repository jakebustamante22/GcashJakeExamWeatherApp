package com.example.gcashtestjweatherapp.di.module

import com.example.gcashtestjweatherapp.source.local.WeatherLocalDataSource
import com.example.gcashtestjweatherapp.source.local.WeatherLocalDataSourceImpl
import com.example.gcashtestjweatherapp.source.remote.WeatherRemoteDataSource
import com.example.gcashtestjweatherapp.source.remote.WeatherRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourcesModule {

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: WeatherLocalDataSourceImpl): WeatherLocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: WeatherRemoteDataSourceImpl): WeatherRemoteDataSource
}

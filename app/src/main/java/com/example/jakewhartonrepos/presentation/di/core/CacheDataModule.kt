package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.data.repository.datasource.RepoCacheDataSource
import com.example.jakewhartonrepos.data.repository.datasourceimpl.RepoCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideRepoCacheDataSource():RepoCacheDataSource{
        return RepoCacheDataSourceImpl()
    }
}
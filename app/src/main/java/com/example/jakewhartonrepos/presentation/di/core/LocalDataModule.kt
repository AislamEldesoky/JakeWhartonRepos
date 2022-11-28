package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.data.db.ReposDao
import com.example.jakewhartonrepos.data.repository.datasource.RepoLocalDataSource
import com.example.jakewhartonrepos.data.repository.datasourceimpl.RepoLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideRepoLocalDataSource(reposDao: ReposDao) : RepoLocalDataSource{
        return RepoLocalDataSourceImpl(reposDao)
    }
}
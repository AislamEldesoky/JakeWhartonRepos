package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.data.api.ReposService
import com.example.jakewhartonrepos.data.repository.datasource.RepoRemoteDataSource
import com.example.jakewhartonrepos.data.repository.datasourceimpl.RepoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRepoRemoteDataSource(reposService: ReposService) : RepoRemoteDataSource{
        return RepoRemoteDataSourceImpl(reposService)
    }
}
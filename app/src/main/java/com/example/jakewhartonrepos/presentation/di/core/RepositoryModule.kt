package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.data.repository.ReposRepositoryImpl
import com.example.jakewhartonrepos.data.repository.datasource.RepoCacheDataSource
import com.example.jakewhartonrepos.data.repository.datasource.RepoLocalDataSource
import com.example.jakewhartonrepos.data.repository.datasource.RepoRemoteDataSource
import com.example.jakewhartonrepos.domain.repository.RepoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepoRepository(
        repoLocalDataSource: RepoLocalDataSource,
        repoRemoteDataSource: RepoRemoteDataSource,
        repoCacheDataSource: RepoCacheDataSource
    ): RepoRepository {
        return ReposRepositoryImpl(repoLocalDataSource, repoRemoteDataSource, repoCacheDataSource)
    }

}
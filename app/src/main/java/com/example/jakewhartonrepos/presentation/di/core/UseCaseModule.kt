package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.domain.repository.RepoRepository
import com.example.jakewhartonrepos.domain.usecase.GetReposUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetRepoUseCase(repoRepository: RepoRepository) : GetReposUseCase{
        return GetReposUseCase(repoRepository)
    }
}
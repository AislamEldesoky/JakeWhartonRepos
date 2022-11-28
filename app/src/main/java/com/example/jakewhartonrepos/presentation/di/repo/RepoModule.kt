package com.example.jakewhartonrepos.presentation.di.repo

import com.example.jakewhartonrepos.domain.usecase.GetReposUseCase
import com.example.jakewhartonrepos.presentation.repo.RepoViewModel
import com.example.jakewhartonrepos.presentation.repo.RepoViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @RepoScope
    @Provides
    fun provideRepoViewModelFactory(getReposUseCase: GetReposUseCase): RepoViewModelFactory {
        return RepoViewModelFactory(getReposUseCase)
    }
}
package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.presentation.di.repo.RepoSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        DatabaseModule::class,
        LocalDataModule::class,
        CacheDataModule::class,
        RemoteDataModule::class
    ]
)
interface AppComponent {
    fun repoSubComponent() : RepoSubComponent.factory
}
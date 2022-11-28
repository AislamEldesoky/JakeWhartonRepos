package com.example.jakewhartonrepos.presentation

import android.app.Application
import com.example.jakewhartonrepos.presentation.di.Injector
import com.example.jakewhartonrepos.presentation.di.core.*
import com.example.jakewhartonrepos.presentation.di.repo.RepoSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun createRepoSubComponent(): RepoSubComponent {
        return appComponent.repoSubComponent().create()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule())
            .remoteDataModule(RemoteDataModule())
            .build()
    }

}
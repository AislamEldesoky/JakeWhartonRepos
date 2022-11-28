package com.example.jakewhartonrepos.presentation.di.core

import android.content.Context
import com.example.jakewhartonrepos.presentation.di.repo.RepoModule
import com.example.jakewhartonrepos.presentation.di.repo.RepoSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [RepoSubComponent::class])
class AppModule (private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context{
        return context.applicationContext
    }
}
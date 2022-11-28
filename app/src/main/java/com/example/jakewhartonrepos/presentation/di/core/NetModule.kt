package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.data.api.ReposService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com/users/JakeWharton/")
            .build()
    }

    @Singleton
    @Provides
    fun provideRepoService(retrofit: Retrofit): ReposService {
        return retrofit.create(ReposService::class.java)
    }
}
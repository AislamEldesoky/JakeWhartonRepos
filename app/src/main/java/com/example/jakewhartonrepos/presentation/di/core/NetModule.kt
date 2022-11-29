package com.example.jakewhartonrepos.presentation.di.core

import com.example.jakewhartonrepos.data.api.ReposService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val okHttpClientBuilder = OkHttpClient.Builder()
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY}
        okHttpClientBuilder.addNetworkInterceptor { chain ->
            chain.proceed(chain.request()
                .newBuilder()
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36")
                .build())
        }.addNetworkInterceptor(logger)
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .baseUrl("https://api.github.com/users/JakeWharton/")
            .build()
    }

    @Singleton
    @Provides
    fun provideRepoService(retrofit: Retrofit): ReposService {
        return retrofit.create(ReposService::class.java)
    }
}
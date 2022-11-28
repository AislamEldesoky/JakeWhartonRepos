package com.example.jakewhartonrepos.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.jakewhartonrepos.data.db.ReposDao
import com.example.jakewhartonrepos.data.db.ReposDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideReposDatabase(context:Context): ReposDatabase{
        return Room.databaseBuilder(
            context,
            ReposDatabase::class.java,
            "reposDatabase"
        ).build()
    }

    @Singleton
    @Provides
    fun provideRepoDao(reposDatabase: ReposDatabase) : ReposDao{
        return reposDatabase.reposDao()
    }
}
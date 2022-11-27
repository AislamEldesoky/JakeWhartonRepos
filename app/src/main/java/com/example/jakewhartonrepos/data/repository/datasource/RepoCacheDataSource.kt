package com.example.jakewhartonrepos.data.repository.datasource

import com.example.jakewhartonrepos.data.model.ReposItem

interface RepoCacheDataSource {

    suspend fun getReposFromCache(): List<ReposItem>
    suspend fun saveReposToCache (repos:List<ReposItem>)

}
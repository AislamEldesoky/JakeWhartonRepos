package com.example.jakewhartonrepos.data.repository.datasourceimpl

import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.data.repository.datasource.RepoCacheDataSource

class RepoCacheDataSourceImpl : RepoCacheDataSource {

    private var reposList = ArrayList<ReposItem>()

    override suspend fun getReposFromCache(): List<ReposItem> {
        return reposList
    }

    override suspend fun saveReposToCache(repos: List<ReposItem>) {
        reposList.clear()
        reposList = ArrayList(repos)
    }
}
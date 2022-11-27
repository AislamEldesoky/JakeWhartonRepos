package com.example.jakewhartonrepos.data.repository.datasourceimpl

import com.example.jakewhartonrepos.data.api.ReposService
import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.data.repository.datasource.RepoRemoteDataSource

class RepoRemoteDataSourceImpl(private val reposService: ReposService) : RepoRemoteDataSource {
    override suspend fun getRepos(pageNumber: Int, perPage: Int): List<ReposItem> =
        reposService.getRepos(pageNumber, perPage)
}
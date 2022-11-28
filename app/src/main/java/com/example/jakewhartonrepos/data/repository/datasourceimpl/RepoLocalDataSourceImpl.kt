package com.example.jakewhartonrepos.data.repository.datasourceimpl

import com.example.jakewhartonrepos.data.db.ReposDao
import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.data.repository.datasource.RepoLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepoLocalDataSourceImpl(private val reposDao: ReposDao) : RepoLocalDataSource {
    override suspend fun getReposFromDB(): List<ReposItem> {
        return reposDao.getRepos()
    }

    override suspend fun saveReposToDB(repos: List<ReposItem>) {
        CoroutineScope(Dispatchers.IO).launch {
            reposDao.insert(repos)
        }
    }
}
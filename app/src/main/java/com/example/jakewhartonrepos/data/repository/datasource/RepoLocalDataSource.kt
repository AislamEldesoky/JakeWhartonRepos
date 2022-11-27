package com.example.jakewhartonrepos.data.repository.datasource

import com.example.jakewhartonrepos.data.model.ReposItem

interface RepoLocalDataSource {

    suspend fun getReposFromDB(): List<ReposItem>
    suspend fun saveReposToDB(repos:List<ReposItem>)

}
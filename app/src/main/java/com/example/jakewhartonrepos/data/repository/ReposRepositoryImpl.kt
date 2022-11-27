package com.example.jakewhartonrepos.data.repository

import android.util.Log
import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.data.repository.datasource.RepoCacheDataSource
import com.example.jakewhartonrepos.data.repository.datasource.RepoLocalDataSource
import com.example.jakewhartonrepos.data.repository.datasource.RepoRemoteDataSource

class ReposRepositoryImpl(
    private val repoLocalDataSource: RepoLocalDataSource,
    private val repoRemoteDataSource: RepoRemoteDataSource,
    private val repoCacheDataSource: RepoCacheDataSource
) {

    suspend fun getReposFromAPI(pageNumber: Int, perPage: Int): List<ReposItem> {
        lateinit var reposList: List<ReposItem>
        try {
            reposList = repoRemoteDataSource.getRepos(pageNumber, perPage)
        } catch (e: Exception) {
            Log.d("ERROR", e.toString())
        }
        return reposList
    }

    suspend fun getPhotosFromDB(pageNumber: Int, perPage: Int): List<ReposItem> {

        lateinit var reposList: List<ReposItem>

        try {
            reposList = repoLocalDataSource.getReposFromDB()
        } catch (e: Exception) {
            Log.d("ERROR", e.toString())
        }
        if (reposList.size > 0) {
            return reposList
        } else {
            reposList = getReposFromAPI(pageNumber, perPage)
            repoLocalDataSource.saveReposToDB(reposList)
        }
        return reposList
    }

    suspend fun getReposFromCache(pageNumber: Int, perPage: Int): List<ReposItem> {
        lateinit var reposList: List<ReposItem>

        try {
            reposList = repoCacheDataSource.getReposFromCache()
        } catch (e: Exception) {
            Log.d("ERROR", e.toString())
        }
        if (reposList.size>0){
            return reposList
        }else{
            reposList = getPhotosFromDB(pageNumber,perPage)
            repoCacheDataSource.saveReposToCache(reposList)
        }
        return reposList
    }

}
package com.example.jakewhartonrepos.data.repository.datasource

import com.example.jakewhartonrepos.data.model.ReposItem

interface RepoRemoteDataSource {

    suspend fun getRepos(pageNumber : Int, perPage:Int):List<ReposItem>
}
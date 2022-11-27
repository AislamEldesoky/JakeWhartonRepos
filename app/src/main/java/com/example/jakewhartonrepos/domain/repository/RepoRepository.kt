package com.example.jakewhartonrepos.domain.repository

import com.example.jakewhartonrepos.data.model.ReposItem

interface RepoRepository {
 suspend fun getRepos(pageNumber:Int,perPage:Int): List<ReposItem>
}
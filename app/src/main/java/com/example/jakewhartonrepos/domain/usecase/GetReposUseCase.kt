package com.example.jakewhartonrepos.domain.usecase

import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.domain.repository.RepoRepository

class GetReposUseCase (private val repository: RepoRepository) {
    suspend fun execute(pageNumber: Int, perPage : Int) : List<ReposItem> = repository.getRepos(pageNumber,perPage)
}
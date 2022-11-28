package com.example.jakewhartonrepos.data.api

import com.example.jakewhartonrepos.data.model.Repos
import com.example.jakewhartonrepos.data.model.ReposItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ReposService {

    @GET("repos")
    suspend fun getRepos(@Query("page") reposPage: Int, @Query("per_page") itemsInPage: Int): List<ReposItem>

}

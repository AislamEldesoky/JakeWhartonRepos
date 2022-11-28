package com.example.jakewhartonrepos.presentation.di.repo

import com.example.jakewhartonrepos.presentation.repo.RepoActivity
import dagger.Subcomponent

@RepoScope
@Subcomponent(modules = [RepoModule::class])
interface RepoSubComponent {

    fun inject(repoActivity: RepoActivity)
    @Subcomponent.Factory
    interface factory{
        fun create(): RepoSubComponent
    }
}
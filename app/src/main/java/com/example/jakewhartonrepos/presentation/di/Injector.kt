package com.example.jakewhartonrepos.presentation.di

import com.example.jakewhartonrepos.presentation.di.repo.RepoSubComponent

interface Injector {
    fun createRepoSubComponent() : RepoSubComponent
}
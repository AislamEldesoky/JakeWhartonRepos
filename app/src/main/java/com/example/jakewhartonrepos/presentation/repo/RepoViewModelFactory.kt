package com.example.jakewhartonrepos.presentation.repo

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jakewhartonrepos.domain.usecase.GetReposUseCase

class RepoViewModelFactory (private val getReposUseCase: GetReposUseCase) : ViewModelProvider.Factory{

    @NonNull
    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepoViewModel(getReposUseCase) as T
    }
}
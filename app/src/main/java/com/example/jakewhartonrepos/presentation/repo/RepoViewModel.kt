package com.example.jakewhartonrepos.presentation.repo

import android.view.View
import androidx.lifecycle.*
import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.domain.usecase.GetReposUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RepoViewModel (private val getReposUseCase: GetReposUseCase) : ViewModel() {
     var repoLiveData: MutableLiveData<List<ReposItem>> = MutableLiveData()
    fun getRepos(pageNumber: Int, perPage:Int) {
        lateinit var reposList: List<ReposItem>
        viewModelScope.launch {
           reposList = getReposUseCase.execute(pageNumber,perPage)
            repoLiveData.value=reposList
        }
    }

}
package com.example.jakewhartonrepos.presentation.repo

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.domain.usecase.GetReposUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RepoViewModel(private val getReposUseCase: GetReposUseCase) : ViewModel() {
    var updateSuccess : MutableLiveData<Boolean> = MutableLiveData()
    var repos : ArrayList<ReposItem> = ArrayList()
    private var pageNumber = 1
    private var perPage = 15
    fun getRepos() {
        repos.clear()
        lateinit var reposList: List<ReposItem>
        viewModelScope.launch {
            reposList = getReposUseCase.execute(pageNumber, perPage)
            if (reposList.isEmpty()||reposList==null) {
                Log.d("Empty","")
                updateSuccess.value =false
            } else {
                Log.d("INSERTING",reposList.size.toString())
                repos.addAll(reposList)
                pageNumber++
                updateSuccess.value = true
            }
        }
    }
init {
    getRepos()
}
}
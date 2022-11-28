package com.example.jakewhartonrepos.presentation.repo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jakewhartonrepos.R
import com.example.jakewhartonrepos.presentation.di.Injector
import javax.inject.Inject

class RepoActivity : AppCompatActivity() {


    lateinit var viewModel: RepoViewModel


    @Inject
    lateinit var factory: RepoViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as Injector).createRepoSubComponent().inject(this)

        viewModel = ViewModelProvider(this,this.factory).get(RepoViewModel::class.java)




//        viewModel.getRepos(1,15).observe(this, Observer {
//            Log.d("ITEM",it.get(1).name)
//        })
    }

    override fun onStart() {
        super.onStart()
        viewModel.getRepos(1,15)
        viewModel.repoLiveData.observe(this, Observer {
            Log.d("ITEMS",it.get(1).name)
        })
    }


}
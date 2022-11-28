package com.example.jakewhartonrepos.presentation.repo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jakewhartonrepos.R
import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.databinding.ActivityMainBinding
import com.example.jakewhartonrepos.presentation.di.Injector
import javax.inject.Inject

class RepoActivity : AppCompatActivity() {


    lateinit var viewModel: RepoViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RepoAdapter
    @Inject
    lateinit var factory: RepoViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        (application as Injector).createRepoSubComponent().inject(this)

        viewModel = ViewModelProvider(this,this.factory).get(RepoViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()
        viewModel.getRepos(1,15)
        viewModel.repoLiveData.observe(this, Observer {
            initView(it)
        })
    }

    fun initView(reposList:List<ReposItem>){
        binding.rvRepo.layoutManager = LinearLayoutManager(this)
        adapter = RepoAdapter()
        binding.rvRepo.adapter = adapter
        adapter.setList(reposList)
    }

}
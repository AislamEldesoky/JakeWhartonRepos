package com.example.jakewhartonrepos.presentation.repo

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jakewhartonrepos.R
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Injector).createRepoSubComponent().inject(this)

        viewModel = ViewModelProvider(this, this.factory).get(RepoViewModel::class.java)
        initEvents()

    }

    override fun onStart() {
        super.onStart()
        viewModel.updateSuccess.observe(this, Observer {
            if (it==true) {
                initView()
                binding.progressBar.isVisible = true
            }else{
                binding.progressBar.isVisible =false
            }

        })
    }

    fun initView() {
        binding.rvRepo.layoutManager = LinearLayoutManager(this)
        adapter = RepoAdapter()
        binding.rvRepo.adapter = adapter
        adapter.setList(viewModel.repos)
    }

    fun initEvents() {
        binding.rvRepo.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Log.d("ONScrollListener", "")
                val visibleItemCount = recyclerView.layoutManager!!.childCount
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                val pastVisibleItems =
                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findFirstVisibleItemPosition()
                if (visibleItemCount + pastVisibleItems >= totalItemCount)
                    try {
                        viewModel.getRepos()
                    }catch (e:Exception){
                        Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG)
                    }
            }
        })
    }

}
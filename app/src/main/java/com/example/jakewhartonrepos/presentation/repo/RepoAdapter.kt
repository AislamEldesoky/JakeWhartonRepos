package com.example.jakewhartonrepos.presentation.repo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jakewhartonrepos.R
import com.example.jakewhartonrepos.data.model.ReposItem
import com.example.jakewhartonrepos.databinding.RvRepoBinding

class RepoAdapter() : RecyclerView.Adapter<RepoViewHolder>() {
    private var reposList = ArrayList<ReposItem>()


    fun setList(repos: List<ReposItem>) {
        reposList.clear()
        reposList.addAll(repos)
    }

    fun updateList(list: ArrayList<ReposItem>) {
        reposList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RvRepoBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.rv_repo, parent, false
        )
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(reposList[position])
    }

    override fun getItemCount(): Int {
        return reposList.size
    }
}

class RepoViewHolder(val binding: RvRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(repo: ReposItem) {
        binding.headerTextView3.text = repo.name
    }
}

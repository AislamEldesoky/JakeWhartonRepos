package com.example.jakewhartonrepos.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.jakewhartonrepos.data.model.ReposItem

@Dao
interface ReposDao {

    @Insert(onConflict = REPLACE)
    fun insert(repos : List<ReposItem>)
//
//    @Query("select * FROM ")
//    fun getRepos: List<ReposItem>

}
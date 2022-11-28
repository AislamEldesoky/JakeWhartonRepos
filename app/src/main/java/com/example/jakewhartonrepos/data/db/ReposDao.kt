package com.example.jakewhartonrepos.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.jakewhartonrepos.data.model.ReposItem

@Dao
interface ReposDao {

    @Insert(onConflict = REPLACE)
  suspend  fun insert(repos : List<ReposItem>)

    @Query("select * FROM repos_items ")
   suspend fun getRepos(): List<ReposItem>
}
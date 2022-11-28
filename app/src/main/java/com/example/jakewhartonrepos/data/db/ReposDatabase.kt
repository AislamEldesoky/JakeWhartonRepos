package com.example.jakewhartonrepos.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jakewhartonrepos.data.model.ReposItem

@Database(entities = [ReposItem::class], version = 4, exportSchema = false)
abstract class ReposDatabase : RoomDatabase() {
    abstract fun reposDao():ReposDao
}
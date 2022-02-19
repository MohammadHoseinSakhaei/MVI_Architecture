package com.example.MVI_Architecture.root.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BlogEntity::class], exportSchema = false, version = 1)
abstract class BlogDataBase :RoomDatabase(){
    abstract fun blogDio(): BlogDio

    companion object{
        const val DATABASE_NAME = "blog_db"
    }
}
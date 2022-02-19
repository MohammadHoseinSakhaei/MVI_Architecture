package com.example.MVI_Architecture.root.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDio {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlog(blog: BlogEntity): Long

    @Query("SELECT * FROM blogsEntity")
    suspend fun getBlog(): List<BlogEntity>

}
package com.example.myapplication.root.datasource

import com.example.myapplication.root.local.BlogEntity

interface LocalBlogDataSource {

    suspend fun getBlogs():List<BlogEntity>

    suspend fun insertBlog(blogEntity: BlogEntity): Long
}
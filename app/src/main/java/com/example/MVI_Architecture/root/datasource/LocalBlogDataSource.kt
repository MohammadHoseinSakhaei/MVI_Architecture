package com.example.MVI_Architecture.root.datasource

import com.example.MVI_Architecture.root.local.BlogEntity

interface LocalBlogDataSource {

    suspend fun getBlogs():List<BlogEntity>

    suspend fun insertBlog(blogEntity: BlogEntity): Long
}
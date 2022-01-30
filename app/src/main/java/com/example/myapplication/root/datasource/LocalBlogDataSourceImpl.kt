package com.example.myapplication.root.datasource

import com.example.myapplication.root.local.BlogDio
import com.example.myapplication.root.local.BlogEntity
import javax.inject.Inject

class LocalBlogDataSourceImpl @Inject constructor(private val blogDio: BlogDio) :
    LocalBlogDataSource {
    override suspend fun getBlogs(): List<BlogEntity> {
        return blogDio.getBlog()
    }

    override suspend fun insertBlog(blogEntity: BlogEntity):Long {
        return blogDio.insertBlog(blogEntity)
    }
}
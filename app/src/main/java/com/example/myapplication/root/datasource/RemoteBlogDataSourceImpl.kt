package com.example.myapplication.root.datasource

import com.example.myapplication.root.remote.BlogRemoteModel
import com.example.myapplication.root.remote.Services

class RemoteBlogDataSourceImpl(private val services: Services): RemoteBlogDataSource {
    override suspend fun getBlogs(): List<BlogRemoteModel.BlogRemoteModelItem> {
        return services.getBlogs()
    }
}
package com.example.MVI_Architecture.root.datasource

import com.example.MVI_Architecture.root.remote.BlogRemoteModel
import com.example.MVI_Architecture.root.remote.Services

class RemoteBlogDataSourceImpl(private val services: Services): RemoteBlogDataSource {
    override suspend fun getBlogs(): List<BlogRemoteModel.BlogRemoteModelItem> {
        return services.getBlogs()
    }
}
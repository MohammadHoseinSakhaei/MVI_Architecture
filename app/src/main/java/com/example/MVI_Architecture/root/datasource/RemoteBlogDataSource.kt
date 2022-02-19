package com.example.MVI_Architecture.root.datasource

import com.example.MVI_Architecture.root.remote.BlogRemoteModel

interface RemoteBlogDataSource {
    suspend fun getBlogs():List<BlogRemoteModel.BlogRemoteModelItem>
}
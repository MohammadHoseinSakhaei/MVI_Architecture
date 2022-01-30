package com.example.myapplication.root.datasource

import com.example.myapplication.root.remote.BlogRemoteModel

interface RemoteBlogDataSource {
    suspend fun getBlogs():List<BlogRemoteModel.BlogRemoteModelItem>
}
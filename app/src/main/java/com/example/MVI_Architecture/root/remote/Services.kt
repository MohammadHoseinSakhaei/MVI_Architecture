package com.example.MVI_Architecture.root.remote

import retrofit2.http.GET

interface Services {
    @GET("blogs")
    suspend fun getBlogs(): List<BlogRemoteModel.BlogRemoteModelItem>
}
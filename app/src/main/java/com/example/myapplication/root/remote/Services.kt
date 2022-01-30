package com.example.myapplication.root.remote

import retrofit2.http.GET

interface Services {
    @GET("blogs")
    suspend fun getBlogs(): List<BlogRemoteModel.BlogRemoteModelItem>
}
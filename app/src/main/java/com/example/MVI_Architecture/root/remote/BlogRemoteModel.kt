package com.example.MVI_Architecture.root.remote

import com.google.gson.annotations.SerializedName


class BlogRemoteModel : ArrayList<BlogRemoteModel.BlogRemoteModelItem>(){
    data class BlogRemoteModelItem(
        @SerializedName("pk")
        val id: Int?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("body")
        val body: String?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("category")
        val category: String?
    )
}
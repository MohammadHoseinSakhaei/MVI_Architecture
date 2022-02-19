package com.example.MVI_Architecture.root.repository

import com.example.MVI_Architecture.root.datasource.LocalBlogDataSource
import com.example.MVI_Architecture.root.datasource.RemoteBlogDataSource
import com.example.MVI_Architecture.root.domain.BlogModel
import com.example.MVI_Architecture.root.local.LocalMapper
import com.example.MVI_Architecture.root.remote.RemoteMapper
import com.example.MVI_Architecture.root.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteBlogDataSource: RemoteBlogDataSource,
    private val localBlogDataSource: LocalBlogDataSource,
    private val remoteMapper: RemoteMapper,
    private val localMapper: LocalMapper
) {

    suspend fun getBlogs(): Flow<DataState<List<BlogModel>>> = flow {
        emit(DataState.Loading)
        try {
            val response = remoteBlogDataSource.getBlogs()
            val blogs = remoteMapper.mapFromEntityList(response)

            blogs.forEach {
                localBlogDataSource.insertBlog(localMapper.mapToEntity(it))
            }

            val getBlogFromDb = localBlogDataSource.getBlogs()
            emit(DataState.Success(localMapper.mapFromEntityList(getBlogFromDb)))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

}
package com.example.myapplication.root.remote

import com.example.myapplication.root.domain.BlogModel
import com.example.myapplication.root.mapper.Mapper
import javax.inject.Inject


class RemoteMapper @Inject constructor() : Mapper<BlogRemoteModel.BlogRemoteModelItem, BlogModel> {
    override fun mapFromEntity(entity: BlogRemoteModel.BlogRemoteModelItem): BlogModel {
        return BlogModel(
            entity.id,
            entity.title,
            entity.body,
            entity.image,
            entity.category
        )
    }

    override fun mapToEntity(domainModel: BlogModel): BlogRemoteModel.BlogRemoteModelItem {
        return BlogRemoteModel.BlogRemoteModelItem(
            domainModel.id,
            domainModel.title,
            domainModel.body,
            domainModel.image,
            domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogRemoteModel.BlogRemoteModelItem>): List<BlogModel> {
        return entities.map { mapFromEntity(it) }
    }
}
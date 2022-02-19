package com.example.MVI_Architecture.root.local

import com.example.MVI_Architecture.root.domain.BlogModel
import com.example.MVI_Architecture.root.mapper.Mapper
import javax.inject.Inject

class LocalMapper @Inject constructor():Mapper<BlogEntity,BlogModel> {
    override fun mapFromEntity(entity: BlogEntity): BlogModel {
        return BlogModel(
            entity.id,
            entity.title,
            entity.body,
            entity.image,
            entity.category
        )
    }

    override fun mapToEntity(domainModel: BlogModel): BlogEntity {
        return BlogEntity(
            domainModel.id,
            domainModel.title,
            domainModel.body,
            domainModel.image,
            domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogEntity>) :List<BlogModel>{
        return entities.map {
            mapFromEntity(it)
        }
    }
}
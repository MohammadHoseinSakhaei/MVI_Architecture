package com.example.MVI_Architecture.root.mapper

interface Mapper<Entity,DomainModel> {

    fun mapFromEntity(entity: Entity) :DomainModel

    fun mapToEntity(domainModel: DomainModel) : Entity


}
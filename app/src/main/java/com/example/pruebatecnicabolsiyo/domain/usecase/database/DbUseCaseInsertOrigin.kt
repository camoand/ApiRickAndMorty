package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.OriginAttributeEntity
import javax.inject.Inject

class DbUseCaseInsertOrigin @Inject constructor(private val databaseRepository: DatabaseRepository) {
    operator fun invoke(originAttributeEntity: OriginAttributeEntity){
        return databaseRepository.setDatabaseOrigin(originAttributeEntity)
    }

}
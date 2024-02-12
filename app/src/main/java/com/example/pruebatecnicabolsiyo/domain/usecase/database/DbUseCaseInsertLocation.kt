package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.LocationAttributeEntity
import javax.inject.Inject

class DbUseCaseInsertLocation @Inject constructor(private val databaseRepository: DatabaseRepository) {
    operator fun invoke(locationAttributeEntity: LocationAttributeEntity) {
        return databaseRepository.setDatabaseLocation(locationAttributeEntity)
    }

}
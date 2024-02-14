package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity
import javax.inject.Inject

class DbUseCaseGetFavorite @Inject constructor(private val databaseRepository: DatabaseRepository) {
    operator fun invoke() : List<CharactersAttributesEntity>{
        return databaseRepository.getDatabaseCharactersFavorite()
    }
}
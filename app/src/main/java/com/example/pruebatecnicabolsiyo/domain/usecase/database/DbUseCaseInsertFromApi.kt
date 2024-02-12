package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import javax.inject.Inject

class DbUseCaseInsertFromApi @Inject constructor(private val  databaseRepository: DatabaseRepository) {

    operator fun invoke(charactersFromApiEntity: List<CharactersFromApiEntity>){
        return databaseRepository.setDatabaseFromApi(charactersFromApiEntity)
    }
}
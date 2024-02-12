package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import javax.inject.Inject

class DbUseCaseUpdateFromApi @Inject constructor(private val databaseRepository: DatabaseRepository) {

    operator fun invoke(charactersFromApiEntity: List<CharactersFromApiEntity>){
        return databaseRepository.updateDatabaseFromApi(charactersFromApiEntity)
    }
}
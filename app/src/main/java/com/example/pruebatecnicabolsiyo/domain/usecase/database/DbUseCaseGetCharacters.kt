package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import javax.inject.Inject

class DbUseCaseGetCharacters @Inject constructor(private val databaseRepository: DatabaseRepository){

    operator fun invoke() : List<CharactersFromApiEntity> {
        return databaseRepository.getDatabaseCharactersFromApi()
    }
}
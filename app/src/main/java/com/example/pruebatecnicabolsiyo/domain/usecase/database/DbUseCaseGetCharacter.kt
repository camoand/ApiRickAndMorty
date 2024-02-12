package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity
import javax.inject.Inject

class DbUseCaseGetCharacter @Inject constructor(private val databaseRepository: DatabaseRepository) {

    operator fun invoke(idCharacter : Int) : List<CharactersAttributesEntity> {
        return databaseRepository.getDatabaseCharacters(idCharacter)
    }

}
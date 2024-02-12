package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity
import javax.inject.Inject

class DbUseCaseInsertCharacter @Inject constructor(
    private val  databaseRepository: DatabaseRepository
) {
    operator fun invoke(charactersAttributesEntity: List<CharactersAttributesEntity>) {
        return databaseRepository.setDatabaseCharacters(charactersAttributesEntity)
    }

}

package com.example.pruebatecnicabolsiyo.domain.usecase.database

import com.example.pruebatecnicabolsiyo.core.DatabaseRepository
import javax.inject.Inject

class DbUseCaseDeleteCharacter @Inject constructor(private val databaseRepository: DatabaseRepository){

    operator fun invoke(idCharacter : Int) : Int {
        return databaseRepository.deleteDatabaseCharacter(idCharacter)
    }

}
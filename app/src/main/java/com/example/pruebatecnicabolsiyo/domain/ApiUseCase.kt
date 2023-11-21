package com.example.pruebatecnicabolsiyo.domain

import com.example.pruebatecnicabolsiyo.core.ApiRepository
import com.example.pruebatecnicabolsiyo.core.model.CharacterAttributes
import javax.inject.Inject

class ApiUseCase @Inject constructor(private val repository: ApiRepository){

    suspend operator fun invoke(): CharacterAttributes {
        return repository.getApi()

    }
}
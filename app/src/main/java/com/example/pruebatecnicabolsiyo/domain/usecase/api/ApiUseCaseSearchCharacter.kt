package com.example.pruebatecnicabolsiyo.domain.usecase.api

import com.example.pruebatecnicabolsiyo.core.ApiRepository
import com.example.pruebatecnicabolsiyo.core.model.Characters
import javax.inject.Inject

class ApiUseCaseSearchCharacter @Inject constructor(private val repository: ApiRepository) {
    suspend operator fun invoke(searchCharacter: String): Characters {
        return repository.getApiSearch(searchCharacter)
    }
}
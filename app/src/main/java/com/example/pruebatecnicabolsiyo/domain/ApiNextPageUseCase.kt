package com.example.pruebatecnicabolsiyo.domain

import com.example.pruebatecnicabolsiyo.core.ApiRepository
import com.example.pruebatecnicabolsiyo.core.model.Characters
import javax.inject.Inject

class ApiNextPageUseCase@Inject constructor(private val repository: ApiRepository) {
    suspend operator fun invoke(nextPage: String): Characters {
        return repository.getApiNextPage(nextPage)
    }
}
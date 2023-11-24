package com.example.pruebatecnicabolsiyo.core

import com.example.pruebatecnicabolsiyo.core.data.ApiService
import com.example.pruebatecnicabolsiyo.core.model.Characters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetServiceApi @Inject constructor(private val apiService: ApiService) {

    suspend fun getApi(): Characters {
        return withContext(Dispatchers.IO){
            val response = apiService.getCharacters()
            response ;
        }
    }
    suspend fun getApiNextPage(nextPage: String): Characters {
        return withContext(Dispatchers.IO){
            val response = apiService.getCharactersChangePage(nextPage)
            response ;
        }
    }
}
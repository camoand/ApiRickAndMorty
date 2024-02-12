package com.example.pruebatecnicabolsiyo.core

import com.example.pruebatecnicabolsiyo.core.model.Characters
import javax.inject.Inject

class ApiRepository @Inject constructor(private val api : GetServiceApi) {

    suspend fun getApi(): Characters {
        return api.getApi()
    }
    suspend fun getApiNextPage(nextPage: String): Characters {
        return api.getApiNextPage(nextPage)
    }

}
package com.example.pruebatecnicabolsiyo.core

import com.example.pruebatecnicabolsiyo.model.CharacterAttributes
import javax.inject.Inject

class ApiRepository @Inject constructor(private val api : GetServiceApi) {

    suspend fun getApi(): CharacterAttributes {
        return api.getApi()
    }

}
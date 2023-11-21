package com.example.pruebatecnicabolsiyo.core.data

import com.example.pruebatecnicabolsiyo.domain.Constans
import com.example.pruebatecnicabolsiyo.core.model.CharacterAttributes
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET(Constans.CHARACTER)
    suspend fun get():Response<CharacterAttributes>
}
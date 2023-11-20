package com.example.pruebatecnicabolsiyo.core.data

import com.example.pruebatecnicabolsiyo.Constans
import com.example.pruebatecnicabolsiyo.model.CharacterAttributes
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET(Constans.CHARACTER)
    suspend fun get():Response<CharacterAttributes>
}
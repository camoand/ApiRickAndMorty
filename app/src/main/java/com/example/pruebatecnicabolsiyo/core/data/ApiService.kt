package com.example.pruebatecnicabolsiyo.core.data

import com.example.pruebatecnicabolsiyo.domain.Constans
import com.example.pruebatecnicabolsiyo.core.model.Characters
import retrofit2.http.GET

interface ApiService {

    @GET(Constans.CHARACTER)
    suspend fun getCharacters():Characters
}
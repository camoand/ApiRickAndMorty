package com.example.pruebatecnicabolsiyo.core.data

import com.example.pruebatecnicabolsiyo.core.model.Characters
import com.example.pruebatecnicabolsiyo.domain.Constans
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constans.CHARACTER)
    suspend fun getCharacters(): Characters

    @GET(Constans.CHARACTER)
    suspend fun getCharactersChangePage(
        @Query("page") urlNextPage: String
    ): Characters

    @GET(Constans.CHARACTER)
    suspend fun getSearchCharacter(
        @Query("name") searchCharacter: String
    ): Characters


}
package com.example.pruebatecnicabolsiyo.core

import com.example.pruebatecnicabolsiyo.core.data.ApiClient
import com.example.pruebatecnicabolsiyo.model.CharacterAttributes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class GetServiceApi @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getApi(): CharacterAttributes{
        return withContext(Dispatchers.IO){
            val response = apiClient.get()
            response.body() ?: response.isSuccessful;
        } as CharacterAttributes
    }

}
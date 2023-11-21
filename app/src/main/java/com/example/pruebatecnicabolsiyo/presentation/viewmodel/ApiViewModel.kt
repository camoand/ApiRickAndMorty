package com.example.pruebatecnicabolsiyo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicabolsiyo.core.data.ApiService
import com.example.pruebatecnicabolsiyo.domain.state.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiViewModel: ViewModel() {
    private val _state = MutableStateFlow<ApiState>(ApiState())
    val state: StateFlow<ApiState> = _state

    private val rickAndMortyService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }

    fun fetchCharacter() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val character = rickAndMortyService.getCharacters()
                _state.value = _state.value.copy(character = character, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message ?: "Unknown error", isLoading = false)
            }
        }
    }



}
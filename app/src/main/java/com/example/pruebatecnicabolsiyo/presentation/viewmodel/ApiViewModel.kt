package com.example.pruebatecnicabolsiyo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicabolsiyo.domain.Constans
import com.example.pruebatecnicabolsiyo.domain.state.ApiState
import com.example.pruebatecnicabolsiyo.domain.usecase.api.ApiNextPageUseCase
import com.example.pruebatecnicabolsiyo.domain.usecase.api.ApiUseCase
import com.example.pruebatecnicabolsiyo.domain.usecase.api.ApiUseCaseSearchCharacter
import com.example.pruebatecnicabolsiyo.presentation.intent.CharacterIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(
    private val apiUseCase: ApiUseCase,
    private val apiNextPageUseCase: ApiNextPageUseCase,
    private val searchCharacter: ApiUseCaseSearchCharacter
) : ViewModel() {
    private val _state = MutableStateFlow(ApiState())
    val state: StateFlow<ApiState> = _state


    fun processIntent(intent: CharacterIntent) {
        when (intent) {
            is CharacterIntent.FetchCharacter -> fetchCharacter()
            is CharacterIntent.NavigateToNextPage -> {
                changePage(intent.urlPage)
            }
            else -> {}
        }
    }

    fun changePage(urlPage: String){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoadingApi = true)
            try {
                val character = apiNextPageUseCase.invoke(urlPage.substring(47))
                _state.value = _state.value.copy(character = character, isLoadingApi = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = e.message ?: Constans.UNKNOWN_ERROR,
                    isLoadingApi = false
                )
            }
        }
    }

    fun fetchCharacter() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoadingApi = true)
            try {
                val character = apiUseCase.invoke()
                _state.value = _state.value.copy(character = character, isLoadingApi = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = e.message ?: Constans.UNKNOWN_ERROR,
                    isLoadingApi = false
                )
            }
        }
    }
      fun searchCharacter(search: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoadingApi = true)
            try {
                val character = searchCharacter.invoke(search)
                _state.value = _state.value.copy(character = character, isLoadingApi = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = e.message ?: Constans.UNKNOWN_ERROR,
                    isLoadingApi = false
                )
            }
        }
    }


}
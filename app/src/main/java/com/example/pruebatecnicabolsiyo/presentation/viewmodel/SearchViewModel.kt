package com.example.pruebatecnicabolsiyo.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pruebatecnicabolsiyo.domain.state.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel : ViewModel() {
    private val _state = MutableStateFlow(ApiState())
    val state: StateFlow<ApiState> = _state

    var searchQuery by mutableStateOf("")
        private set


}

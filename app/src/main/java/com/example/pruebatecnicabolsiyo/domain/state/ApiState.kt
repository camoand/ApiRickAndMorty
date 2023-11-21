package com.example.pruebatecnicabolsiyo.domain.state

import com.example.pruebatecnicabolsiyo.core.model.Characters

data class ApiState(
    val isLoading: Boolean = false,
    val character: Characters? = null,
    val error: String = ""
)

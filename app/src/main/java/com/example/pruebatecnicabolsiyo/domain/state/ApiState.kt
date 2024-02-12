package com.example.pruebatecnicabolsiyo.domain.state

import com.example.pruebatecnicabolsiyo.core.model.Characters
import com.example.pruebatecnicabolsiyo.domain.Constans

data class ApiState(
    val isLoadingApi: Boolean = false,
    val character: Characters? = null,
    val error: String = Constans.ERROR_MESSAGE
)

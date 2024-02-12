package com.example.pruebatecnicabolsiyo.domain.state

import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import com.example.pruebatecnicabolsiyo.core.model.Characters
import com.example.pruebatecnicabolsiyo.domain.Constans

data class DatabaseState(
    val isSuccessInDatabase: Boolean = false,
    val isCreateDatabase: Boolean = false,
    val isFavorite: Boolean = false,
    val isInDatabase: Int = 0,
    val isGetInDatabase: Boolean = false,
    val characterInsertDatabase: Characters? = null,
    val characterGetDatabase: List<CharactersFromApiEntity>? = null,
    val error: String = Constans.ERROR_MESSAGE
)

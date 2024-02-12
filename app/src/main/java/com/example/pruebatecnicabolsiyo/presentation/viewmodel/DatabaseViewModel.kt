package com.example.pruebatecnicabolsiyo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.toDomainChaAttDelete
import com.example.pruebatecnicabolsiyo.core.database.entity.toDomainChaAttEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.toDomainChaAttEntityFA
import com.example.pruebatecnicabolsiyo.core.model.CharactersAttributes
import com.example.pruebatecnicabolsiyo.core.model.toDomainChaAttFromApi
import com.example.pruebatecnicabolsiyo.domain.state.DatabaseState
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseDeleteCharacter
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseGetCharacter
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseGetCharacters
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseInsertCharacter
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseInsertFromApi
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseInsertLocation
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseInsertOrigin
import com.example.pruebatecnicabolsiyo.domain.usecase.database.DbUseCaseUpdateFromApi
import com.example.pruebatecnicabolsiyo.presentation.intent.CharacterIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatabaseViewModel @Inject constructor(
    private val insertAttributesDatabase: DbUseCaseInsertCharacter,
    private val getAttributesDatabase: DbUseCaseGetCharacter,
    private val getAttributeDatabaseFromApi: DbUseCaseGetCharacters,
    private val insertFromApi: DbUseCaseInsertFromApi,
    private val deleteCharacter: DbUseCaseDeleteCharacter,
    private val updateFromApi: DbUseCaseUpdateFromApi
) : ViewModel() {
    private val _stateDatabase = MutableStateFlow(DatabaseState())
    val stateDatabase: StateFlow<DatabaseState> = _stateDatabase

    fun processIntent(intent: CharacterIntent) {
        when (intent) {
            is CharacterIntent.FavCharacter -> saveCharacterFav(intent.charactersFav)
            is CharacterIntent.ReadDatabase -> readInDatabase()
            is CharacterIntent.SaveDatabase -> saveDatabase(intent.charactersAttributes)
            else -> {}
        }

    }

    private fun saveDatabase(charactersAttributes: CharactersAttributes) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: List<CharactersAttributes> = listOf(charactersAttributes)
            try {
                insertFromApi.invoke(response.map { it.toDomainChaAttFromApi() })
                _stateDatabase.value = _stateDatabase.value.copy(isSuccessInDatabase = true)
            } catch (e: Exception) {
                _stateDatabase.value = _stateDatabase.value.copy(isSuccessInDatabase = false)
            }

        }
    }

    private fun saveCharacterFav(charactersFromApiEntity: CharactersFromApiEntity) {
        // existInDatabase(characterFav)
        viewModelScope.launch(Dispatchers.IO) {
            val getCharacter = getAttributesDatabase.invoke(charactersFromApiEntity.id)
            val response: List<CharactersFromApiEntity> = listOf(charactersFromApiEntity)
            if (getCharacter.isNotEmpty()){
                updateFromApi.invoke(response.map { it.toDomainChaAttDelete() })
                deleteCharacter.invoke(charactersFromApiEntity.id)
                val consult = getAttributeDatabaseFromApi.invoke()
                _stateDatabase.value = _stateDatabase.value.copy(
                    characterGetDatabase = consult
                )
            }else{
                insertAttributesDatabase.invoke(response.map { it.toDomainChaAttEntity() })
                updateFromApi.invoke(response.map { it.toDomainChaAttEntityFA() })
                val consult = getAttributeDatabaseFromApi.invoke()
                _stateDatabase.value = _stateDatabase.value.copy(
                    isCreateDatabase = true,
                    isGetInDatabase = true,
                    characterGetDatabase = consult
                )
            }
        }
    }

    private fun readInDatabase() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getAttributeDatabaseFromApi.invoke()
                if (response.isNotEmpty()) {
                    _stateDatabase.value = _stateDatabase.value.copy(
                        isGetInDatabase = true,
                        characterGetDatabase = response
                    )
                }
            } catch (e: Exception) {
                _stateDatabase.value = _stateDatabase.value.copy(isGetInDatabase = false)
            }

        }

    }
}


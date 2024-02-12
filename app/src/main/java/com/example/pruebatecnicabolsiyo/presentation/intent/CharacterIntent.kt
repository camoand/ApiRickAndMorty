package com.example.pruebatecnicabolsiyo.presentation.intent

import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import com.example.pruebatecnicabolsiyo.core.model.CharactersAttributes

sealed class CharacterIntent{
    object FetchCharacter : CharacterIntent()
    data class FavCharacter(var charactersFav: CharactersFromApiEntity) : CharacterIntent()
    object ReadDatabase: CharacterIntent()
    data class NavigateToNextPage(var urlPage: String) : CharacterIntent()
    data class SaveDatabase(var charactersAttributes: CharactersAttributes) : CharacterIntent()

}

package com.example.pruebatecnicabolsiyo.presentation.intent

sealed class CharacterIntent{
    object FetchCharacter : CharacterIntent()
    data class NavigateToNextPage(var urlPage: String) : CharacterIntent()

}

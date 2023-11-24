package com.example.pruebatecnicabolsiyo.core.model

data class CharactersAttributes(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginAttribute,
    val location: LocationAttribute,
    val image: String,
    val episode: MutableList<String>,
    val url: String,
    val created: String
)

package com.example.pruebatecnicabolsiyo.core.model

data class CharactersAttributes(
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var origin: OriginAttribute,
    var location: LocationAttribute,
    var image: String,
    var episode: MutableList<String>,
    var url: String,
    var created: String
)

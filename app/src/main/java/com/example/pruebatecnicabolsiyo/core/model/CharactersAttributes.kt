package com.example.pruebatecnicabolsiyo.core.model

import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity

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
fun CharactersAttributes.toDomainChaAttEntity() = CharactersAttributesEntity(id,name, status ,species,type,gender,image,url, created)
fun CharactersAttributes.toDomainChaAttFromApi() = CharactersFromApiEntity(id,name, status ,species,type,gender,image,url, created,save = false)

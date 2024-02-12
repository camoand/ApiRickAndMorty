package com.example.pruebatecnicabolsiyo.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CharactersFromApiEntity")
data class CharactersFromApiEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String,
    val save: Boolean = false
)

fun CharactersFromApiEntity.toDomainChaAttEntity() = CharactersAttributesEntity(id,name, status ,species,type,gender,image,url, created,save = true)
fun CharactersFromApiEntity.toDomainChaAttEntityFA() = CharactersFromApiEntity(id,name, status ,species,type,gender,image,url, created,save = true)
fun CharactersFromApiEntity.toDomainChaAttDelete() = CharactersFromApiEntity(id,name, status ,species,type,gender,image,url, created,save = false)


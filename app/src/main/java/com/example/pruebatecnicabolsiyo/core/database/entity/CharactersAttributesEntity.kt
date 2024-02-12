package com.example.pruebatecnicabolsiyo.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CharactersAttributesEntity")
data class CharactersAttributesEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
//    val episode: List<String>,
    val url: String,
    val created: String,
    val save: Boolean = true
)


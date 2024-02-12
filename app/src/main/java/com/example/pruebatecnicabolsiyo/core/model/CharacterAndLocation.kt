package com.example.pruebatecnicabolsiyo.core.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.LocationAttributeEntity


data class CharacterAndLocation(
    @Embedded
val charactersAttributesEntity: CharactersAttributesEntity,
    @Relation(
    parentColumn = "id",
    entityColumn = "locationId"
)
val locationAttributeEntity: LocationAttributeEntity
)

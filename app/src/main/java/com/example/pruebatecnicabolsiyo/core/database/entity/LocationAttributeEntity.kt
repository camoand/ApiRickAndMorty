package com.example.pruebatecnicabolsiyo.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LocationAttributeEntity")
data class LocationAttributeEntity(
    @PrimaryKey val characterId: Int,
    val name: String,
    val url: String
)
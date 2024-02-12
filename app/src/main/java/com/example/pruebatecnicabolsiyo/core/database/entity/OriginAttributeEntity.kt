package com.example.pruebatecnicabolsiyo.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "OriginAttributeEntity")
data class OriginAttributeEntity(
    @PrimaryKey val characterId: Int,
    val name: String,
    val url: String
)
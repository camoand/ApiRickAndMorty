package com.example.pruebatecnicabolsiyo.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "InfoAttributeEntity")
data class InfoAttributesEntity(
    @PrimaryKey var characterId: Long = 0,
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)
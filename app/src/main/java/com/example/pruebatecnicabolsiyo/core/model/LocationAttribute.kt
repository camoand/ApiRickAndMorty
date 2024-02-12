package com.example.pruebatecnicabolsiyo.core.model

import com.example.pruebatecnicabolsiyo.core.database.entity.LocationAttributeEntity

data class LocationAttribute(
    val name: String,
    val url: String
)
fun LocationAttribute.toDomainLocAttEntity() = LocationAttributeEntity(0,name, url)

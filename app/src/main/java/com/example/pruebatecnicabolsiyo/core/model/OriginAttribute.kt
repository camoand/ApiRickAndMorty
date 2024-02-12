package com.example.pruebatecnicabolsiyo.core.model

import com.example.pruebatecnicabolsiyo.core.database.entity.OriginAttributeEntity

data class OriginAttribute(
    val name: String,
    val url: String
)
fun OriginAttribute.toDomainOriAttEntity() = OriginAttributeEntity(0,name,url)

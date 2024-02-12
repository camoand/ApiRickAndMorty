package com.example.pruebatecnicabolsiyo.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnicabolsiyo.core.database.dao.CharactersAttributesDAO
import com.example.pruebatecnicabolsiyo.core.database.dao.CharactersFromApiDao
import com.example.pruebatecnicabolsiyo.core.database.dao.LocationAttributeDao
import com.example.pruebatecnicabolsiyo.core.database.dao.OriginAttributeDao
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.LocationAttributeEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.OriginAttributeEntity


@Database(entities = [CharactersAttributesEntity::class, OriginAttributeEntity::class, LocationAttributeEntity::class, CharactersFromApiEntity::class],version = 1)
abstract class CharactersDataBase : RoomDatabase(){

    abstract fun CharactersAttributesDAO(): CharactersAttributesDAO
    abstract fun LocationAttributeDAO(): LocationAttributeDao
    abstract fun OriginAttributeDao(): OriginAttributeDao
    abstract fun CharactersFromApiDao(): CharactersFromApiDao

}
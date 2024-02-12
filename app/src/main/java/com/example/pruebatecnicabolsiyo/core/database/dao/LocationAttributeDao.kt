package com.example.pruebatecnicabolsiyo.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.pruebatecnicabolsiyo.core.database.entity.LocationAttributeEntity

@Dao
interface LocationAttributeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacterFavLocation(charactersLocation: LocationAttributeEntity)
}
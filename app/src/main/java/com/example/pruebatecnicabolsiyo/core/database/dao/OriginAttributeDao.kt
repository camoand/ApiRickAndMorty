package com.example.pruebatecnicabolsiyo.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.pruebatecnicabolsiyo.core.database.entity.OriginAttributeEntity

@Dao
interface OriginAttributeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacterFavOrigin(charactersOrigin : OriginAttributeEntity)
}
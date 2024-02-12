package com.example.pruebatecnicabolsiyo.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity

@Dao
interface CharactersFromApiDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCharacterFromApi(charactersFromApiEntity: List<CharactersFromApiEntity>)

    @Update()
    fun updateCharacterFromApi(charactersFromApiEntity: List<CharactersFromApiEntity>)

    @Query("SELECT * FROM CharactersFromApiEntity")
    fun  getCharactersDatabase() : MutableList<CharactersFromApiEntity>
}
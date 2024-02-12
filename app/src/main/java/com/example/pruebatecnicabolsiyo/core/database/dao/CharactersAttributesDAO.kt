package com.example.pruebatecnicabolsiyo.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity

@Dao
interface CharactersAttributesDAO {
    @Query("SELECT * FROM CharactersAttributesEntity")
    fun  getAllCharactersFav() : MutableList<CharactersAttributesEntity>
    @Query("SELECT * FROM CharactersAttributesEntity WHERE id = :idCharacter")
    fun  getCharactersFav(idCharacter : Int) : MutableList<CharactersAttributesEntity>
    @Insert()
    fun addCharacterFav(charactersFav: List<CharactersAttributesEntity>)

    @Query("DELETE FROM CharactersAttributesEntity WHERE id = :charactersFav")
    fun deleteCharacterFav(charactersFav: Int) : Int

    /*
        @Update
        fun updateCharactersFav()

        @Delete
        fun deleteCharactersFav()*/
}
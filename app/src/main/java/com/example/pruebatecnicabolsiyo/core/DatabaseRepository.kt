package com.example.pruebatecnicabolsiyo.core

import com.example.pruebatecnicabolsiyo.core.database.dao.CharactersAttributesDAO
import com.example.pruebatecnicabolsiyo.core.database.dao.CharactersFromApiDao
import com.example.pruebatecnicabolsiyo.core.database.dao.LocationAttributeDao
import com.example.pruebatecnicabolsiyo.core.database.dao.OriginAttributeDao
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersAttributesEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.CharactersFromApiEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.LocationAttributeEntity
import com.example.pruebatecnicabolsiyo.core.database.entity.OriginAttributeEntity
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val charactersAttributesDAO: CharactersAttributesDAO,
    private val locationAttributeDao: LocationAttributeDao,
    private val originAttributeDao: OriginAttributeDao,
    private val charactersFromApiDao: CharactersFromApiDao
) {

    fun getDatabaseCharacters(idCharacter : Int): List<CharactersAttributesEntity> {
        return charactersAttributesDAO.getCharactersFav(idCharacter)
    }
    fun setDatabaseCharacters(charactersAttributesEntity: List<CharactersAttributesEntity>) {
        return charactersAttributesDAO.addCharacterFav(charactersAttributesEntity)
    }
    fun getDatabaseCharactersFavorite(): List <CharactersAttributesEntity> {
        return charactersAttributesDAO.getAllCharactersFav()
    }
    fun deleteDatabaseCharacter(idCharacter: Int): Int {
        return charactersAttributesDAO.deleteCharacterFav(idCharacter)
    }


    fun setDatabaseLocation(locationAttributeEntity: LocationAttributeEntity) {
        return locationAttributeDao.addCharacterFavLocation(locationAttributeEntity)
    }


    fun setDatabaseOrigin(originAttributeEntity: OriginAttributeEntity) {
        return originAttributeDao.addCharacterFavOrigin(originAttributeEntity)
    }


    fun setDatabaseFromApi(charactersFromApiEntity: List<CharactersFromApiEntity>){
        return charactersFromApiDao.addCharacterFromApi(charactersFromApiEntity)
    }
    fun updateDatabaseFromApi(charactersFromApiEntity: List<CharactersFromApiEntity>){
        return charactersFromApiDao.updateCharacterFromApi(charactersFromApiEntity)
    }
    fun getDatabaseCharactersFromApi(): List<CharactersFromApiEntity> {
        return charactersFromApiDao.getCharactersDatabase()
    }




}
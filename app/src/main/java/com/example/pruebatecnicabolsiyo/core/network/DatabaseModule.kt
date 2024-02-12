package com.example.pruebatecnicabolsiyo.core.network

import android.content.Context
import androidx.room.Room
import com.example.pruebatecnicabolsiyo.core.database.CharactersDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val CHARACTER_DATABASE_NAME = "CharacterDataBase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CharactersDataBase::class.java, CHARACTER_DATABASE_NAME).build()
    @Singleton
    @Provides
    fun provideCharacterAttributeDao(dataBase: CharactersDataBase) = dataBase.CharactersAttributesDAO()
    @Singleton
    @Provides
    fun provideCharacterOriginDao(dataBase: CharactersDataBase) = dataBase.OriginAttributeDao()
    @Singleton
    @Provides
    fun provideCharacterLocationDao(dataBase: CharactersDataBase) = dataBase.LocationAttributeDAO()
    @Singleton
    @Provides
    fun provideCharacterFromApiDao(dataBase: CharactersDataBase) = dataBase.CharactersFromApiDao()


}
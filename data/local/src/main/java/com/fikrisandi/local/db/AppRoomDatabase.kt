package com.fikrisandi.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fikrisandi.local.dao.PokemonDao
import com.fikrisandi.model.local.pokemon.PokemonEntity

@Database(
    entities = [PokemonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}
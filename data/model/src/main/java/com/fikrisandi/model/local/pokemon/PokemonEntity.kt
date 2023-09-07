package com.fikrisandi.model.local.pokemon

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PokemonEntity.NAME)
data class PokemonEntity(
    @PrimaryKey(true) var id: Int = 0,
    @ColumnInfo var name: String = "",
    @ColumnInfo var url: String = "",
){
    companion object{
        const val NAME = "pokemon"
    }
}
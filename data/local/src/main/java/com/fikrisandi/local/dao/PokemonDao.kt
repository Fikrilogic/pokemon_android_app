package com.fikrisandi.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.fikrisandi.framework.room.BaseDao
import com.fikrisandi.model.local.pokemon.PokemonEntity

@Dao
interface PokemonDao : BaseDao<PokemonEntity> {

    @Query("SELECT * FROM ${PokemonEntity.NAME}")
    suspend fun getAll(): List<PokemonEntity>

    @Query(
        "SELECT * FROM ${PokemonEntity.NAME} " +
                "WHERE name LIKE '%' || :search || '%' OR :search = ''" +
                "ORDER BY CASE WHEN :sort = 'ASC' THEN NAME END ASC," +
                "CASE WHEN :sort = 'DESC' THEN NAME END DESC " +
                "LIMIT :limit OFFSET :offset"
    )
    suspend fun getAll(limit: Int, offset: Int, sort: String, search: String): List<PokemonEntity>

    @Query("SELECT * FROM ${PokemonEntity.NAME} WHERE name = :name")
    suspend fun getByName(name: String): PokemonEntity?

}
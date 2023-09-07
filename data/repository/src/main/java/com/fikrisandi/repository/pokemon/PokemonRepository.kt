package com.fikrisandi.repository.pokemon

import com.fikrisandi.model.local.pokemon.PokemonEntity
import com.fikrisandi.model.remote.pokemon.PokemonInfo
import com.fikrisandi.model.remote.pokemon.PokemonListResponse

interface PokemonRepository {

    suspend fun getAll(limit: Int, offset: Int): PokemonListResponse

    suspend fun getAllLocal(): List<PokemonEntity>
    suspend fun getAllLocal(limit: Int, offset: Int, sort: String, search: String): List<PokemonEntity>

    suspend fun get(id: Int): PokemonInfo
    suspend fun save(data: PokemonEntity)

    suspend fun saveAll(data: List<PokemonEntity>)
}
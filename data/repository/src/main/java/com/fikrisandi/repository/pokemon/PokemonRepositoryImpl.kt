package com.fikrisandi.repository.pokemon

import com.fikrisandi.local.dao.PokemonDao
import com.fikrisandi.model.local.pokemon.PokemonEntity
import com.fikrisandi.model.remote.pokemon.PokemonInfo
import com.fikrisandi.model.remote.pokemon.PokemonListResponse
import com.fikrisandi.remote.service.PokemonService
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val service: PokemonService,
    private val dao: PokemonDao
) : PokemonRepository {

    override suspend fun getAll(limit: Int, offset: Int): PokemonListResponse {
        return service.getPokemonList(limit, offset)
    }

    override suspend fun getAllLocal(): List<PokemonEntity> {
        return dao.getAll()
    }

    override suspend fun getAllLocal(
        limit: Int,
        offset: Int,
        sort: String,
        search: String
    ): List<PokemonEntity> {
        return dao.getAll(limit, offset, sort, search)
    }

    override suspend fun get(id: Int): PokemonInfo {
        return service.getPokemon(id)
    }

    override suspend fun save(data: PokemonEntity) {
        val dataExist = dao.getByName(data.name)
        if (dataExist == null) dao.insert(data)
    }

    override suspend fun saveAll(data: List<PokemonEntity>) {
        dao.insert(data)
    }

}
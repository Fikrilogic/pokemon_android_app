package com.fikrisandi.remote.service

import com.fikrisandi.model.remote.pokemon.PokemonInfo
import com.fikrisandi.model.remote.pokemon.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonService {
    companion object{
        const val POKEMON = "pokemon"
    }

    @GET(POKEMON)
    suspend fun getPokemonList(
    ):PokemonListResponse

    @GET(POKEMON)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ):PokemonListResponse

    @GET("$POKEMON/{id}")
    suspend fun getPokemon(
        @Path("id") pokemonId: Int
    ): PokemonInfo


    @GET
    suspend fun getPokemon(
        @Url url: String
    ): PokemonInfo


}
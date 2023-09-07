package com.fikrisandi.detail

import com.fikrisandi.model.dto.pokemon.PokemonDto


data class DetailState(
    val pokemon: PokemonDto
)

sealed class DetailEvent {

    data class LoadPokemonDetail(val id: Int) : DetailEvent()
}

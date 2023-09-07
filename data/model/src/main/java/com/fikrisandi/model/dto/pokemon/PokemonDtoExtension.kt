package com.fikrisandi.model.dto.pokemon

import com.fikrisandi.model.remote.pokemon.PokemonInfo

fun PokemonInfo.toDto() = PokemonDto(
    id = this.id,
    abilities = this.abilities,
    name = this.name,
    sprites = this.sprites
)
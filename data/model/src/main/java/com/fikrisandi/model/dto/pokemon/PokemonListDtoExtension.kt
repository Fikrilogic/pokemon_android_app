package com.fikrisandi.model.dto.pokemon

import com.fikrisandi.model.local.pokemon.PokemonEntity

fun PokemonEntity.toDto() = PokemonListDto(
    id = this.id,
    name = this.name,
    url = this.url,
)
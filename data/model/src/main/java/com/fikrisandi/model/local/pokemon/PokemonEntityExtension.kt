package com.fikrisandi.model.local.pokemon

import com.fikrisandi.model.remote.pokemon.Pokemon

fun Pokemon.toEntity() = PokemonEntity(
    name = this.name,
    url = this.url,
)
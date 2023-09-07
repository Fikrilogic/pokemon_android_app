package com.fikrisandi.model.dto.pokemon

import android.os.Parcelable
import com.fikrisandi.model.remote.pokemon.PokemonInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDto(
    var id: Int = 0,
    var abilities: List<PokemonInfo.Ability> = listOf(),
    var baseExperience: Int = 0,
    var height: Int = 0,
    var isDefault: Boolean = false,
    var locationAreaEncounters: String = "",
    var name: String = "",
    var order: Int = 0,
    var species: PokemonInfo.Species = PokemonInfo.Species(),
    var sprites: PokemonInfo.Sprites = PokemonInfo.Sprites(),
    var stats: List<PokemonInfo.Stat> = listOf(),
    var types: List<PokemonInfo.Type> = listOf(),
    var weight: Int = 0
): Parcelable

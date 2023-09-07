package com.fikrisandi.home

import androidx.paging.PagingData
import com.fikrisandi.model.dto.pokemon.PokemonListDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class HomeState(

    val listPokemon: Flow<PagingData<PokemonListDto>> = emptyFlow(),
)

sealed class HomeEvent{

    data object LoadPokemon: HomeEvent()
}
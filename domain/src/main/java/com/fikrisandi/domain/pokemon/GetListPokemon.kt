package com.fikrisandi.domain.pokemon

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fikrisandi.framework.extension.classTag
import com.fikrisandi.framework.usecase.FlowPagingUseCase
import com.fikrisandi.model.dto.pokemon.PokemonListDto
import com.fikrisandi.repository.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListPokemon @Inject constructor(private val repository: PokemonRepository) :
    FlowPagingUseCase<GetListPokemon.Params, PokemonListDto>() {
    data class Params(
        val pagingConfig: PagingConfig,
        val option: Map<String, String>
    )

    override fun execute(params: Params): Flow<PagingData<PokemonListDto>> {
        Log.e(this.classTag, "execute: domain pokemon", )
        return Pager(
            config = params.pagingConfig,
            pagingSourceFactory = { PokemonListPagingSource(repository, params.option) }
        ).flow
    }
}
package com.fikrisandi.domain.pokemon

import android.util.Log
import com.fikrisandi.framework.extension.classTag
import com.fikrisandi.framework.network.ApiState
import com.fikrisandi.framework.usecase.ReturnUseCase
import com.fikrisandi.model.dto.pokemon.PokemonDto
import com.fikrisandi.model.dto.pokemon.toDto
import com.fikrisandi.repository.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailPokemon @Inject constructor(private val repository: PokemonRepository) :
    ReturnUseCase<GetDetailPokemon.Params, ApiState<PokemonDto>>() {
    data class Params(
        val url: String = ""
    )

    override suspend fun execute(params: Params): Flow<ApiState<PokemonDto>> {
        return flow {
            try {
                val data = repository.get(params.url)
                Log.e(this.classTag, "execute: $data ", )
                emit(ApiState.Success(data.toDto()))
            } catch (e: Exception) {
                emit(ApiState.Error(e))
            }
        }
    }


}
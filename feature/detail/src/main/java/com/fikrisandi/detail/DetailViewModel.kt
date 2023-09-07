package com.fikrisandi.detail

import com.fikrisandi.domain.pokemon.GetDetailPokemon
import com.fikrisandi.framework.base.BaseUiState
import com.fikrisandi.framework.base.MvviViewModel
import com.fikrisandi.framework.network.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getDetailPokemon: GetDetailPokemon) :
    MvviViewModel<BaseUiState<DetailState>, DetailEvent>() {

    override fun onTrigger(eventType: DetailEvent) {
        when (eventType) {
            is DetailEvent.LoadPokemonDetail -> {
                loadPokemonDetail(eventType.id)
            }
        }
    }

    private fun loadPokemonDetail(id: Int) = safeLaunch {
        startLoading()

        val params = GetDetailPokemon.Params(
            id = id
        )

        call(
            getDetailPokemon(params)
        ) {
            when (it) {
                is ApiState.Error -> {
                    setState(BaseUiState.Error(it.error))
                }

                is ApiState.Success -> {
                    setState(BaseUiState.Data(DetailState(pokemon = it.result)))
                }
            }
        }
    }
}
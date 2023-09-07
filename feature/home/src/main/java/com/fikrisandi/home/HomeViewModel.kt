package com.fikrisandi.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.fikrisandi.domain.pokemon.GetListPokemon
import com.fikrisandi.framework.base.BaseUiState
import com.fikrisandi.framework.base.MvviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

    private val getListPokemon: GetListPokemon
) : MvviViewModel<BaseUiState<HomeState>, HomeEvent>() {

    var sortState by mutableStateOf("DESC")
    var search by mutableStateOf("")

    private val config = PagingConfig(initialLoadSize = 20, prefetchDistance = 10, pageSize = 100)
    override fun onTrigger(eventType: HomeEvent) {
        when (eventType) {
            is HomeEvent.LoadPokemon -> {
                loadPokemon()
            }
        }
    }

    fun handleSortState() {
        when (sortState) {
            "DESC" -> {
                sortState = "ASC"
            }

            "ASC" -> {
                sortState = "DESC"
            }
        }
    }

    fun handleSearch(text: String){
        search = text
    }

    private fun loadPokemon() = safeLaunch {
        setState(BaseUiState.Empty)
        val params = GetListPokemon.Params(
            pagingConfig = config, option = mapOf(
                "sort" to sortState,
                "search" to search
            )
        )
        val pagedFlow = getListPokemon(params).cachedIn(scope = viewModelScope)
        setState(BaseUiState.Data(HomeState(listPokemon = pagedFlow)))
    }

}
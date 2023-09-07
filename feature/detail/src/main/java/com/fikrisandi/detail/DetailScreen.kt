package com.fikrisandi.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.fikrisandi.detail.view.DetailContent
import com.fikrisandi.framework.base.BaseUiState
import com.fikrisandi.provider.NavigationProvider
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph


@Destination
@RootNavGraph(start = true)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navigationProvider: NavigationProvider,
    viewModel: DetailViewModel = hiltViewModel(),
    id: Int = 0,
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        if (state !is BaseUiState.Data) viewModel.onTrigger(DetailEvent.LoadPokemonDetail(id))
    })

    DetailContent(modifier = modifier, navigationProvider = navigationProvider, state = state)
}
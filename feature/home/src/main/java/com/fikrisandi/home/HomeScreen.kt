package com.fikrisandi.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.fikrisandi.home.view.HomeContent
import com.fikrisandi.provider.NavigationProvider
import com.ramcosta.composedestinations.annotation.Destination


@Destination(start = true)
@Composable
fun HomeScreen(
    navController: NavigationProvider,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onTrigger(HomeEvent.LoadPokemon)
    }

    LaunchedEffect(key1 = viewModel.sortState, key2 = viewModel.search, block = {
        viewModel.onTrigger(HomeEvent.LoadPokemon)
    })

    HomeContent(
        modifier = modifier.fillMaxSize(),
        uiState,
        navController = navController,
        sortState = viewModel.sortState,
        handleSortState = {
            viewModel.handleSortState()
        },
        handleSearch = {
            viewModel.handleSearch(it)
        }
    )

}
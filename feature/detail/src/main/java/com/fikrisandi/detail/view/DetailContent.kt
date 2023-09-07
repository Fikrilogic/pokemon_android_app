package com.fikrisandi.detail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fikrisandi.component.widget.EmptyData
import com.fikrisandi.component.widget.LoaderDialog
import com.fikrisandi.detail.DetailState
import com.fikrisandi.framework.base.BaseUiState
import com.fikrisandi.framework.extension.cast
import com.fikrisandi.model.dto.pokemon.PokemonDto
import com.fikrisandi.provider.EmptyNavigationProvider
import com.fikrisandi.provider.NavigationProvider
import com.fikrisandi.theme.PokemonTheme
import com.fikrisandi.theme.PokemonsThemeColors
import com.fikrisandi.theme.PokemonsThemeTypography
import com.fikrisandi.theme.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    navigationProvider: NavigationProvider,
    state: BaseUiState<*>
) {
    Scaffold(modifier = modifier, topBar = {
        TopAppBar(
            title = {
                Text(
                    "Pokemon",
                    style = PokemonsThemeTypography.headlineLarge,
                    color = PokemonsThemeColors.background
                )
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = PokemonsThemeColors.primary,
                titleContentColor = PokemonsThemeColors.background
            ),
            navigationIcon = {
                IconButton(onClick = { navigationProvider.navigateUp() }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_left),
                        contentDescription = "back"
                    )
                }
            }
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when(state){
                is BaseUiState.Data -> {
                    val data = state.cast<BaseUiState.Data<DetailState>>().value.pokemon
                    DetailData(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        data = data
                    )
                }
                is BaseUiState.Error -> {
                    EmptyData()
                }
                is BaseUiState.Empty -> {
                    EmptyData()
                }
                is BaseUiState.Loading -> {
                    LoaderDialog()
                }
            }

        }
    }
}

@Preview
@Composable
fun DetailContentPreview() {
    PokemonTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = PokemonsThemeColors.background) {
            DetailContent(
                modifier = Modifier.fillMaxSize(),
                navigationProvider = EmptyNavigationProvider(),
                state = BaseUiState.Data(DetailState(pokemon = PokemonDto()))
            )
        }
    }
}
package com.fikrisandi.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.fikrisandi.component.widget.EmptyData
import com.fikrisandi.component.widget.LoaderDialog
import com.fikrisandi.framework.base.BaseUiState
import com.fikrisandi.framework.extension.cast
import com.fikrisandi.home.HomeState
import com.fikrisandi.theme.R
import com.fikrisandi.provider.EmptyNavigationProvider
import com.fikrisandi.provider.NavigationProvider
import com.fikrisandi.theme.PokemonTheme
import com.fikrisandi.theme.PokemonsThemeColors
import com.fikrisandi.theme.PokemonsThemeShapes
import com.fikrisandi.theme.PokemonsThemeTypography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    state: BaseUiState<*>,
    navController: NavigationProvider = EmptyNavigationProvider(),
    sortState: String,
    handleSortState: () -> Unit = {},
    handleSearch: (String) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var openBottomSheet by remember {
        mutableStateOf(false)
    }

    var searchState by remember {
        mutableStateOf("")
    }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    LaunchedEffect(openBottomSheet) {
        if (!openBottomSheet) sheetState.hide() else sheetState.expand()
    }

    Scaffold(
        modifier = modifier,
        topBar = {
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
                )
            )
        },
        floatingActionButton = {

        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 70.dp)
                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = searchState, onValueChange = {
                        searchState = it
                    }, modifier = Modifier
                        .fillMaxWidth(.6f)
                        .fillMaxHeight(), trailingIcon = {
                        IconButton(onClick = { handleSearch.invoke(searchState) }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_search),
                                contentDescription = "Submit Search"
                            )
                        }
                    }, keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        handleSearch.invoke(searchState)
                    })
                )
                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(),
                    shape = PokemonsThemeShapes.small,
                    onClick = handleSortState
                ) {
                    Text("Sort", style = PokemonsThemeTypography.labelMedium)
                    Icon(
                        painter = if (sortState == "ASC") painterResource(R.drawable.ic_arrow_up) else painterResource(
                            R.drawable.ic_arrow_down
                        ),
                        contentDescription = "Sort"
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                when (state) {
                    is BaseUiState.Loading -> {
                        LoaderDialog()
                    }

                    is BaseUiState.Empty -> {
                        EmptyData()
                    }

                    is BaseUiState.Data -> {
                        val data =
                            state.cast<BaseUiState.Data<HomeState>>().value.listPokemon.collectAsLazyPagingItems()
                        HomePokemonListContent(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            data = data,
                            navController = navController
                        )
                    }

                    is BaseUiState.Error -> {
                        EmptyData()
                    }
                }
            }
        }

    }
}

@Composable
@Preview
fun HomeContentPreview() {

    PokemonTheme {
        HomeContent(
            modifier = Modifier.fillMaxSize(),
            BaseUiState.Data(HomeState()),
            sortState = "DESC",
        )
    }
}
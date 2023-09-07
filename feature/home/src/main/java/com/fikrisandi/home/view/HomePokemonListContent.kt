package com.fikrisandi.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.fikrisandi.model.dto.pokemon.PokemonListDto
import com.fikrisandi.provider.NavigationProvider
import com.fikrisandi.theme.PokemonsThemeColors
import com.fikrisandi.theme.PokemonsThemeTypography
import com.fikrisandi.theme.R


@Composable
fun HomePokemonListContent(
    modifier: Modifier = Modifier,
    data: LazyPagingItems<PokemonListDto>,
    navController: NavigationProvider
) {

    LazyColumn(modifier = modifier) {
        items(data.itemCount) { index ->
            data[index]?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable { navController.navigateToDetail(it.url) },
                    horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Start)
                ) {
                    Icon(painter = painterResource(R.drawable.ic_file),
                        contentDescription = it.name,tint = PokemonsThemeColors.onBackground)
                    Text(it.name, style = PokemonsThemeTypography.bodyLarge)
                }
            }

        }
    }
}
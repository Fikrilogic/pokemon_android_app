package com.fikrisandi.detail.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.fikrisandi.model.dto.pokemon.PokemonDto
import com.fikrisandi.theme.PokemonsThemeTypography
import org.jetbrains.annotations.Async

@Composable
fun DetailData(modifier: Modifier = Modifier, data: PokemonDto) {
    val context = LocalContext.current

    Column(
        modifier = modifier
    ) {
        Text(
            "Pikachu",
            style = PokemonsThemeTypography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        Log.e("Detail Data", "DetailData: ${data.sprites.frontDefault} ", )
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(data.sprites.frontDefault)
                .crossfade(true).build(), contentDescription = data.name,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 250.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                "Abilities",
                style = PokemonsThemeTypography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(data.abilities.size) { index ->
                    val ability = data.abilities[index]
                    Text(ability.ability.name, style = PokemonsThemeTypography.bodyLarge)
                }
            }
        }
    }
}
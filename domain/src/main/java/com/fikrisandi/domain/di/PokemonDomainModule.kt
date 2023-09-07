package com.fikrisandi.domain.di

import com.fikrisandi.domain.pokemon.GetListPokemon
import com.fikrisandi.repository.pokemon.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonDomainModule {

    @Provides
    @Singleton
    fun provideGetListPokemon(repository: PokemonRepository) = GetListPokemon(repository)
}
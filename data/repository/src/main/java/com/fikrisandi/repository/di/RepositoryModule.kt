package com.fikrisandi.repository.di

import com.fikrisandi.local.dao.PokemonDao
import com.fikrisandi.remote.service.PokemonService
import com.fikrisandi.repository.pokemon.PokemonRepository
import com.fikrisandi.repository.pokemon.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    @Singleton
    fun providePokemonRepository(service: PokemonService, dao: PokemonDao): PokemonRepository =
        PokemonRepositoryImpl(service, dao)
}
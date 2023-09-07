package com.fikrisandi.domain.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [PokemonDomainModule::class])
@InstallIn(SingletonComponent::class)
class DomainModule {
}
package com.example.pokedex.repository

import com.example.pokedex.repository.interfaces.PokemonSource
import com.example.pokedex.repository.manager.PokemonRepositoryManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repo: PokemonRepositoryManager) : PokemonSource
}
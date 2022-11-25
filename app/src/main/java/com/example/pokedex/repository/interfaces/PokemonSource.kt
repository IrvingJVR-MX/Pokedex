package com.example.pokedex.repository.interfaces

import com.apollographql.apollo.api.Response
import com.graphqlapollo.PokemonListQuery

interface PokemonSource {
    suspend fun getPokemons(): Response<PokemonListQuery.Data>
}
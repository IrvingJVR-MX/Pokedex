package com.example.pokedex.repository.interfaces

import com.apollographql.apollo.api.Response
import com.graphqlapollo.PokemonListQuery

interface PokemonRepository {
    suspend fun getPokemons(): Response<PokemonListQuery.Data>
}
package com.example.pokedex.repository.interfaces

import com.apollographql.apollo.api.Response
import com.graphqlapollo.PokemonDetailQuery
import com.graphqlapollo.PokemonListQuery

interface PokemonSource {
    suspend fun getPokemons(): Response<PokemonListQuery.Data>
    suspend fun getPokemonDetail(name: String): Response<PokemonDetailQuery.Data>
}
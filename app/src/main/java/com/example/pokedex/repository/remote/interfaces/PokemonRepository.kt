package com.example.pokedex.repository.remote.interfaces

import com.apollographql.apollo.api.Response
import com.graphqlapollo.PokemonAboutInfoQuery
import com.graphqlapollo.PokemonListQuery
import com.graphqlapollo.PokemonStatsInfoQuery
import com.graphqlapollo.PokemonTypeInfoQuery

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Response<PokemonListQuery.Data>
    suspend fun getPokemonAboutInfo(name: String): Response<PokemonAboutInfoQuery.Data>
    suspend fun getPokemonStatsInfo(name: String): Response<PokemonStatsInfoQuery.Data>
    suspend fun getPokemonTypeInfo(name: String): Response<PokemonTypeInfoQuery.Data>
}

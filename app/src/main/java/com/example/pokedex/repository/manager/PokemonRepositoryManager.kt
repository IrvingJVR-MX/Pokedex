package com.example.pokedex.repository.manager

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.pokedex.repository.api.PokemonApi
import com.example.pokedex.repository.interfaces.PokemonSource
import com.graphqlapollo.PokemonAboutInfoQuery
import com.graphqlapollo.PokemonListQuery
import com.graphqlapollo.PokemonStatsInfoQuery
import com.graphqlapollo.PokemonTypeInfoQuery
import javax.inject.Inject

class PokemonRepositoryManager @Inject constructor (private val pokemonApi: PokemonApi): PokemonSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): Response<PokemonListQuery.Data> {
        return pokemonApi.getApolloClient().query(PokemonListQuery(limit, offset)).await()
    }

    override suspend fun getPokemonAboutInfo(name: String): Response<PokemonAboutInfoQuery.Data> {
       return pokemonApi.getApolloClient().query(PokemonAboutInfoQuery(name)).await()
    }

    override suspend fun getPokemonStatsInfo(name: String): Response<PokemonStatsInfoQuery.Data> {
      return  pokemonApi.getApolloClient().query(PokemonStatsInfoQuery(name)).await()
    }

    override suspend fun getPokemonTypeInfo(name: String): Response<PokemonTypeInfoQuery.Data> {
        return pokemonApi.getApolloClient().query(PokemonTypeInfoQuery(name)).await()
    }

}
package com.example.pokedex.repository.remote.manager

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.pokedex.repository.api.PokemonApi
import com.example.pokedex.repository.remote.interfaces.PokemonRepository
import com.graphqlapollo.PokemonAboutInfoQuery
import com.graphqlapollo.PokemonListQuery
import com.graphqlapollo.PokemonStatsInfoQuery
import com.graphqlapollo.PokemonTypeInfoQuery
import javax.inject.Inject

class PokemonManager @Inject constructor (private val pokemonApi: PokemonApi):
    PokemonRepository {
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
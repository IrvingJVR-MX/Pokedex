package com.example.pokedex.repository.manager

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.pokedex.repository.api.PokemonApi
import com.example.pokedex.repository.interfaces.PokemonRepository
import com.graphqlapollo.PokemonListQuery
import javax.inject.Inject

class PokemonRepositoryManager @Inject constructor (private val pokemonApi: PokemonApi): PokemonRepository {
    override suspend fun getPokemons(): Response<PokemonListQuery.Data> {
        return pokemonApi.getApolloClient().query(PokemonListQuery()).await()
    }

}
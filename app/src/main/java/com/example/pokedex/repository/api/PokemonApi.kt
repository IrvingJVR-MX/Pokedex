package com.example.pokedex.repository.api

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class PokemonApi {
    fun getApolloClient(): ApolloClient{
        check(Looper.myLooper() == Looper.getMainLooper()){
            "Only the main thread can get the apolloClient instance"
        }
        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.builder()
            .serverUrl("https://graphql-pokeapi.graphcdn.app/")
            .okHttpClient(okHttpClient)
            .build()
    }
}
package com.example.pokedex


import com.example.pokedex.dataSource.FakePokemonData
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun checkPokemonListData() {
        assertEquals("bulbasaur", FakePokemonData.pokemonList[0].name)
        assertEquals(6, FakePokemonData.pokemonList.size)
    }
    @Test
    fun checkPokemonAboutInfo() {
        assertEquals("charmander", FakePokemonData.pokemonAboutInfo.pokemon?.name ?: "")
        assertEquals(85, FakePokemonData.pokemonAboutInfo.pokemon?.weight ?: 0)
        assertEquals(6, FakePokemonData.pokemonAboutInfo.pokemon?.height ?: 0)
    }
    @Test
    fun checkPokemonStatsInfo() {
        assertEquals(1, FakePokemonData.pokemonStatsInfo.pokemon?.stats?.size ?: 0)
    }
    @Test
    fun checkPokemonTypeInfo() {
        assertEquals(1, FakePokemonData.pokemonTypeInfo.pokemon?.types?.size ?: 0)
    }
}
package com.example.pokedex.dataSource

import com.graphqlapollo.PokemonAboutInfoQuery
import com.graphqlapollo.PokemonListQuery
import com.graphqlapollo.PokemonStatsInfoQuery
import com.graphqlapollo.PokemonTypeInfoQuery

object FakePokemonData {
     val pokemonList = listOf(
        PokemonListQuery.Result(
            "",
            1,
            "bulbasaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
        ),
        PokemonListQuery.Result(
            "",
            2,
            "ivysaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png"
        ),
        PokemonListQuery.Result(
            "",
            3,
            "venusaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png"
        ),
        PokemonListQuery.Result(
            "",
            4,
            "charmander",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"
        ),
        PokemonListQuery.Result(
            "",
            5,
            "charmeleon",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/5.png"
        ),
        PokemonListQuery.Result(
            "",
            6,
            "charizard",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png"
        )

    )
     val pokemonAboutInfo = PokemonAboutInfoQuery.Data(
        PokemonAboutInfoQuery.Pokemon(
            "",
            4,
            "charmander",
            6,
            85,
            listOf(
                PokemonAboutInfoQuery.Move(
                    "",
                    PokemonAboutInfoQuery.Move1("", "mega-punch")
                )
            ),
            listOf(
                PokemonAboutInfoQuery.Ability(
                    "",
                    PokemonAboutInfoQuery.Ability1("", "solar-power")
                )
            ),
            listOf(
                PokemonAboutInfoQuery.Type(
                    "",
                    PokemonAboutInfoQuery.Type1("", "fire")
                )
            )
        )
    )
     val pokemonStatsInfo = PokemonStatsInfoQuery.Data(
        PokemonStatsInfoQuery.Pokemon(
            "",
            listOf(
                PokemonStatsInfoQuery.Stat(
                    "", PokemonStatsInfoQuery.Stat1("", "hp"), 30, 0
                )
            )
        )
    )

     val pokemonTypeInfo = PokemonTypeInfoQuery.Data(
        PokemonTypeInfoQuery.Pokemon(
            "",
            listOf(PokemonTypeInfoQuery.Type("", PokemonTypeInfoQuery.Type1("", "fire")))
        )
    )

}
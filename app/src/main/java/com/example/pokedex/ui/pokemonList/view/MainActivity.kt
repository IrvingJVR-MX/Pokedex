package com.example.pokedex.ui.pokemonList.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.utils.ViewState
import com.example.pokedex.ui.pokemonList.adapter.PokemonListAdapter
import com.example.pokedex.ui.pokemonList.viewModel.PokemonViewModel
import com.graphqlapollo.PokemonListQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PokemonViewModel by viewModels()
    private lateinit var adapter: PokemonListAdapter
    private var pokemonList = mutableListOf<PokemonListQuery.Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.queryPokemonList()
        observeData()
    }
    private fun observeData(){
        viewModel.pokemonList.observe(this){ response ->
            when(response) {
               is ViewState.Success ->{
                   val results = response.value?.data?.pokemons?.results
                   pokemonList = results as MutableList<PokemonListQuery.Result>
                   initList()
               }
                else -> {
                    pokemonList = mutableListOf()
                }
            }
        }
    }
    private fun initList() {
        adapter = PokemonListAdapter(pokemonList)
        setRecycler()
    }
    private fun setRecycler() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
         binding.rvPokemon.adapter = adapter
         binding.rvPokemon.layoutManager = linearLayoutManager
    }
}
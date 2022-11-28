package com.example.pokedex.ui.pokemonList.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.ui.pokemonDetail.PokemonDetail
import com.example.pokedex.utils.ViewState
import com.example.pokedex.ui.pokemonList.adapter.PokemonListAdapter
import com.example.pokedex.ui.pokemonList.viewModel.PokemonListViewModel
import com.graphqlapollo.PokemonListQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonList : AppCompatActivity(), PokemonListAdapter.IListListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PokemonListViewModel by viewModels()
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
                is ViewState.Error -> {
                    pokemonList = mutableListOf()
                    initList()
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    pokemonList = mutableListOf()
                }
            }
        }

    }
    private fun initList() {
        adapter = PokemonListAdapter(pokemonList, this)
        setRecycler()
    }
    private fun setRecycler() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
         binding.rvPokemon.adapter = adapter
         binding.rvPokemon.layoutManager = linearLayoutManager
    }

    override fun pokemonDetail(name: String, image : String) {
        val intent = Intent(this, PokemonDetail::class.java)
        intent.putExtra("pokemonName",name)
        intent.putExtra("pokemonImage", image)
        startActivity(intent)
    }
}
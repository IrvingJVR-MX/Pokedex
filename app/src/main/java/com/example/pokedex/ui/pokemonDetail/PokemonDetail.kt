package com.example.pokedex.ui.pokemonDetail

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.databinding.ActivityPokemonDetailBinding
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonDetailQuery
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailBinding
    private val viewModel: PokemonDetailViewModel by viewModels()
    private lateinit var pokemonDetail: PokemonDetailQuery.Pokemon
    private lateinit var pokemonName: String
    private lateinit var pokemonImage: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeData()
        pokemonName = intent.getStringExtra("pokemonName") ?: ""
        pokemonImage = intent.getStringExtra("pokemonImage") ?: ""
        initPokemonData()
        viewModel.queryPokemonDetail(pokemonName)
    }
    private fun initPokemonData(){
        val url = pokemonImage
        Picasso.get()
            .load(url)
            .into(binding.ivPokemonDetailImage)
        binding.tvPokemonDetailName.text = pokemonName
    }
    private fun observeData() {
        viewModel.pokemonDetail.observe(this){ response ->
            when(response) {
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemon
                    if (results != null) {
                        pokemonDetail = results
                    }
                }
                else -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
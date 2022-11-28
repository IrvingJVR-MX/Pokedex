package com.example.pokedex.ui.pokemonDetail

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.databinding.ActivityPokemonDetailBinding
import com.example.pokedex.ui.pokemonDetail.adapter.ViewPageAdapter
import com.example.pokedex.utils.ViewState
import com.google.android.material.tabs.TabLayoutMediator
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
        initAdapter()
    }
    private fun initAdapter(){
        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            when(position) {
                0 -> {
                    tab.text = getString(R.string.about)
                }
                1 -> {
                    tab.text =  getString(R.string.stats)
                }
                2 -> {
                    tab.text =  getString(R.string.evolution)
                }
            }

        }.attach()
    }
    private fun initPokemonData(){
        val url = pokemonImage
        Picasso.get()
            .load(url)
            .into(binding.ivPokemonDetailImage)
        binding.tvPokemonDetailName.text = pokemonName.replaceFirstChar { it.uppercase() }
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
                is ViewState.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                else -> {
                }
            }
        }
    }
}
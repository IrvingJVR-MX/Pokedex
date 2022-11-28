package com.example.pokedex.ui.pokemonDetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityPokemonDetailBinding
import com.example.pokedex.ui.pokemonDetail.adapter.ViewPageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailBinding
    private var pokemonName: String = ""
    private var pokemonImage: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null) {
            pokemonName =  bundle.getString("pokemonName", "")
            pokemonImage = bundle.getString("pokemonImage", "")
        }
        initPokemonData()
        initAdapter()
    }
    private fun initAdapter(){
        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle, pokemonName)
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

}
package com.example.pokedex.ui.pokemonDetail.view

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityPokemonDetailBinding
import com.example.pokedex.ui.pokemonDetail.adapter.ViewPageAdapter
import com.example.pokedex.ui.pokemonDetail.viewmodel.PokemonDetailViewModel
import com.example.pokedex.utils.ViewState
import com.google.android.material.tabs.TabLayoutMediator
import com.graphqlapollo.PokemonTypeInfoQuery
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailBinding
    private var pokemonName: String = ""
    private var pokemonImage: String = ""
    private val viewModel: PokemonDetailViewModel by viewModels()
    private lateinit var pokemonTypeInfo: PokemonTypeInfoQuery.Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null) {
            pokemonName =  bundle.getString("pokemonName", "")
            pokemonImage = bundle.getString("pokemonImage", "")
        }
        observeData()
        viewModel.queryPokemonType(pokemonName)
        initPokemonData()
        initAdapter()
    }
    private fun initColor(){
        val typeObj = pokemonTypeInfo.types?.first()
        val typeName = typeObj?.type?.name?.let { it }.toString().trim()
        val packageName: String = this.packageName
        val desiredColour = ResourcesCompat.getColor(this.resources, resources.getIdentifier(typeName, "color",packageName),this.theme)
        binding.pokemonDetailLayout.setBackgroundColor(desiredColour)
        binding.tabLayout.setBackgroundColor(desiredColour)
    }

    private fun observeData() {
        viewModel.pokemonTypeInfo.observe(this){ response ->
            when(response) {
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemon
                    if (results != null) {
                        pokemonTypeInfo = results
                        initColor()
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
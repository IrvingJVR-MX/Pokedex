package com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.pokedex.databinding.FragmentAboutBinding
import com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment.viewmodel.AboutViewModel
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonAboutInfoQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment(name: String, color: Int) : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private lateinit var pokemonAboutInfo: PokemonAboutInfoQuery.Pokemon
    private val viewModel: AboutViewModel by viewModels()
    private var pokemonName: String = name
    private var pokemonColor: Int = color
    private var loading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        viewModel.queryPokemonDetail(pokemonName)
        binding.tvPokemonData.setTextColor(pokemonColor)
    }

    private fun observeData() {
        viewModel.pokemonAboutInfo.observe(viewLifecycleOwner){ response ->
            when(response) {
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemon
                    if (results != null) {
                        pokemonAboutInfo = results
                        initPokemonData()
                    }
                }
                is ViewState.Error -> {
                    Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                }
                is ViewState.Loading -> {
                    loading = true
                }
                else -> {
                    Toast.makeText(activity, "unknown Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun initPokemonData() {
        val pokemonWeight = "${pokemonAboutInfo.weight}Kg"
        binding.tvPokemonHeight.text = pokemonAboutInfo.height.toString()
        binding.tvPokemonWeight.text = pokemonWeight
        var pokemonType = ""
        pokemonAboutInfo.types?.forEach { typeName ->
            typeName!!.type?.name?.let { pokemonType += ", ${it.replaceFirstChar { it.uppercase()}} "}
        }
        binding.tvType.text = pokemonType.replaceFirstChar {""}
        var pokemonAbilities = ""
        pokemonAboutInfo.abilities?.forEach { abilitiesName ->
            pokemonAbilities += (", " + abilitiesName?.ability?.name) ?: ""
        }
        binding.tvAbilities.text = pokemonAbilities.replaceFirstChar { "" }
        var pokemonMoves = ""
        pokemonAboutInfo.moves?.forEach{ moveName ->
            pokemonMoves+= (", " + moveName?.move?.name) ?: ""
        }
        binding.tvMoves.text = pokemonMoves.replaceFirstChar { "" }
    }

}
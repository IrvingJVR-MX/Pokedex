package com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.pokedex.databinding.FragmentAboutBinding
import com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment.viewmodel.PokemonDetailViewModel
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonDetailQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment(name: String) : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!
    private lateinit var pokemonDetail: PokemonDetailQuery.Pokemon
    private val viewModel: PokemonDetailViewModel by viewModels()
    private var pokemonName: String = name

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
    }

    private fun observeData() {
        viewModel.pokemonDetail.observe(viewLifecycleOwner){ response ->
            when(response) {
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemon
                    if (results != null) {
                        pokemonDetail = results
                        initPokemonData()
                    }
                }
                is ViewState.Error -> {
                    Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                }
                else -> {
                }
            }
        }
    }

    private fun initPokemonData() {
        binding.tvPokemonHeight.text = pokemonDetail.height.toString()
        binding.tvPokemonWeight.text = pokemonDetail.weight.toString()
        var pokemonType = ""
        pokemonDetail.types?.forEach { typeName ->
            typeName!!.type?.name?.let { pokemonType += ", ${it.replaceFirstChar { it.uppercase()}} "}
        }
        binding.tvType.text = pokemonType.replaceFirstChar {""}
        var pokemonAbilities = ""
        pokemonDetail.abilities?.forEach { abilitiesName ->
            pokemonAbilities += (", " + abilitiesName?.ability?.name) ?: ""
        }
        binding.tvAbilities.text = pokemonAbilities.replaceFirstChar { "" }
        var pokemonMoves = ""
        pokemonDetail.moves?.forEach{ moveName ->
            pokemonMoves+= (", " + moveName?.move?.name) ?: ""
        }
        binding.tvMoves.text = pokemonMoves.replaceFirstChar { "" }
    }

}
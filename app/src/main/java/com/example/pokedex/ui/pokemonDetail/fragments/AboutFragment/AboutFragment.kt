package com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.pokedex.databinding.FragmentAboutBinding
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonDetailQuery

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
        Toast.makeText(activity, pokemonName, Toast.LENGTH_SHORT).show()

        // observeData()
        //viewModel.queryPokemonDetail(pokemonName)
    }

    private fun observeData() {
        viewModel.pokemonDetail.observe(viewLifecycleOwner){ response ->
            when(response) {
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemon
                    if (results != null) {
                        pokemonDetail = results
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

}
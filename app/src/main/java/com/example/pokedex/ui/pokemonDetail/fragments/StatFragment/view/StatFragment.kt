package com.example.pokedex.ui.pokemonDetail.fragments.StatFragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.pokedex.databinding.FragmentStatBinding
import com.example.pokedex.ui.pokemonDetail.fragments.StatFragment.viewmodel.StatViewModel
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonStatsInfoQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatFragment(name: String, color: Int) : Fragment() {
    private var _binding: FragmentStatBinding? = null
    private val binding get() = _binding!!
    private lateinit var pokemonStats: PokemonStatsInfoQuery.Pokemon
    private val viewModel: StatViewModel by viewModels()
    private var pokemonName: String = name
    private var pokemonColor: Int = color
    private var loading =  false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        viewModel.queryPokemonStats(pokemonName)
        binding.tvBaseStats.setTextColor(pokemonColor)
    }

    private fun observeData() {
        viewModel.pokemonStats.observe(viewLifecycleOwner){ response ->
            when(response){
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemon
                    if (results != null) {
                        pokemonStats = results
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
        var total =  0
        //Hp
        val hpObj = pokemonStats.stats?.find { it?.stat?.name == "hp" }
        binding.tvPokemonHp.text = hpObj?.base_stat.toString()
        binding.pbPokemonHp.progress  = hpObj?.base_stat ?: 0
        binding.pbPokemonHp.setIndicatorColor(pokemonColor)
        total += hpObj?.base_stat ?: 0
        //Attack
        val atkObj = pokemonStats.stats?.find { it?.stat?.name == "attack" }
        binding.tvPokemonAtk.text = atkObj?.base_stat.toString()
        binding.pbPokemonAtk.progress = atkObj?.base_stat ?:0
        binding.pbPokemonAtk.setIndicatorColor(pokemonColor)
        total += atkObj?.base_stat ?:0
        //Defense
        val defObj = pokemonStats.stats?.find { it?.stat?.name == "defense" }
        binding.tvPokemonDef.text =  defObj?.base_stat.toString()
        binding.pbPokemonDef.progress = defObj?.base_stat ?:0
        binding.pbPokemonDef.setIndicatorColor(pokemonColor)
        total += defObj?.base_stat ?:0
        //Special atk
        val spAtkObj = pokemonStats.stats?.find { it?.stat?.name == "special-attack" }
        binding.tvPokemonSpAtk.text = spAtkObj?.base_stat.toString()
        binding.pbPokemonSpAtk.progress = spAtkObj?.base_stat ?:0
        binding.pbPokemonSpAtk.setIndicatorColor(pokemonColor)
        total += spAtkObj?.base_stat ?:0
        //Special def
        val spDefObj = pokemonStats.stats?.find { it?.stat?.name == "special-defense" }
        binding.tvPokemonSpDef.text = spDefObj?.base_stat.toString()
        binding.pbPokemonSpDef.progress =  spDefObj?.base_stat ?:0
        binding.pbPokemonSpDef.setIndicatorColor(pokemonColor)
        total += spDefObj?.base_stat ?:0
        //Speed
        val speedObj = pokemonStats.stats?.find { it?.stat?.name == "speed" }
        binding.tvPokemonSpeed.text =  speedObj?.base_stat.toString()
        binding.pbPokemonSpeed.progress = speedObj?.base_stat ?:0
        binding.pbPokemonSpeed.setIndicatorColor(pokemonColor)
        total += speedObj?.base_stat ?:0
        //Total
        binding.tvPokemonTotal.text = total.toString()
    }
}
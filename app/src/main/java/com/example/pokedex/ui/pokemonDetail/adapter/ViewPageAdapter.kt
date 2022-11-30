package com.example.pokedex.ui.pokemonDetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment.view.AboutFragment
import com.example.pokedex.ui.pokemonDetail.fragments.EvolutionFragment.view.EvolutionFragment
import com.example.pokedex.ui.pokemonDetail.fragments.StatFragment.view.StatFragment

internal class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, pokemonName: String, pokemonColor: Int): FragmentStateAdapter(fragmentManager, lifecycle){
    private val _pokemonName = pokemonName
    private val _pokemonColor = pokemonColor

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       return when (position){
            0-> {
                AboutFragment(_pokemonName, _pokemonColor)
            }
            1-> {
                StatFragment(_pokemonName, _pokemonColor)
            }
            2 -> {
                EvolutionFragment()
            }
            else -> {
                Fragment()
            }

        }
    }

}
package com.example.pokedex.ui.pokemonDetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment.view.AboutFragment
import com.example.pokedex.ui.pokemonDetail.fragments.EvolutionFragment.EvolutionFragment
import com.example.pokedex.ui.pokemonDetail.fragments.StatFragment.StatFragment

internal class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, pokemonName: String): FragmentStateAdapter(fragmentManager, lifecycle){
    private val _pokemonName = pokemonName

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       return when (position){
            0-> {
                AboutFragment(_pokemonName)
            }
            1-> {
                StatFragment()
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
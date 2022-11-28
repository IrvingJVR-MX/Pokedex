package com.example.pokedex.ui.pokemonDetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokedex.ui.pokemonDetail.AboutFragment
import com.example.pokedex.ui.pokemonDetail.EvolutionFragment
import com.example.pokedex.ui.pokemonDetail.StatFragment

internal class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       return when (position){
            0-> {
                AboutFragment()
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
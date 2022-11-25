package com.example.pokedex.ui.pokemonList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.PokemonItemBinding
import com.graphqlapollo.PokemonListQuery


class PokemonListAdapter(private val pokemonDetailList: MutableList<PokemonListQuery.Result>) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> () {

    class PokemonViewHolder(val binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun fillData(postDetail: PokemonListQuery.Result) {
            binding.tvPokemonName.text = postDetail.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PokemonItemBinding.inflate(inflater, null, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonDetailList[position]
        holder.fillData(pokemon)

    }

    override fun getItemCount(): Int {
        return pokemonDetailList.size
    }
}
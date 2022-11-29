package com.example.pokedex.ui.pokemonList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.PokemonItemBinding
import com.graphqlapollo.PokemonListQuery
import com.squareup.picasso.Picasso


class PokemonListAdapter(private val pokemonDetailList: MutableList<PokemonListQuery.Result>, private val listener: IListListener) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> () {
    interface IListListener {
        fun pokemonDetail(name: String, image: String)
    }
    class PokemonViewHolder(val binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun fillData(pokemonDetail: PokemonListQuery.Result) {
            val url = pokemonDetail.artwork
            Picasso.get()
                .load(url)
                .into(binding.ivPokemon)
            val pokemonName = pokemonDetail.name?.replaceFirstChar{it.uppercase()}
            binding.tvPokemonName.text = pokemonName
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
        holder.binding.cvPokemon.setOnClickListener{
            val name = pokemon.name?.let { pokemon.name} ?: ""
            val image = pokemon.artwork?.let { pokemon.artwork } ?: ""
            listener.pokemonDetail(name, image)
        }
    }

    override fun getItemCount(): Int {
        return pokemonDetailList.size
    }
}
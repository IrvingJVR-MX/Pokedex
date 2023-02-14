package com.example.pokedex.ui.pokemonList.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.PokemonItemBinding
import com.example.pokedex.utils.IListListener
import com.example.pokedex.utils.PokemonHelper
import com.graphqlapollo.PokemonListQuery
import com.squareup.picasso.Picasso


class PokemonListAdapter(private var pokemonDetailList: ArrayList<PokemonListQuery.Result>, private val listener: IListListener) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> () {

    fun filterList(filterList: ArrayList<PokemonListQuery.Result>) {
        pokemonDetailList = filterList
        notifyDataSetChanged()
    }

    class PokemonViewHolder(val binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun fillData(pokemonDetail: PokemonListQuery.Result) {
            val typeColor = Color.parseColor(PokemonHelper.Constants.pokemonMapColor[pokemonDetail.id.toString()])
            val pokemonId = "#${pokemonDetail.id}"
            binding.cvPokemon.setBackgroundColor(typeColor)
            binding.tvPokemonId.text = pokemonId
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
            val id = pokemon.id?.let { pokemon.id.toString() } ?: ""
            listener.pokemonDetail(name, id ,image)
        }
    }

    override fun getItemCount(): Int {
        return pokemonDetailList.size
    }
}
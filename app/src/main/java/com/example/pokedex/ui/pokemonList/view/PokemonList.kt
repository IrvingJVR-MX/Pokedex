package com.example.pokedex.ui.pokemonList.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.ui.pokemonDetail.view.PokemonDetail
import com.example.pokedex.ui.pokemonList.adapter.PokemonListAdapter
import com.example.pokedex.ui.pokemonList.viewModel.PokemonListViewModel
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonListQuery
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PokemonList : AppCompatActivity(), PokemonListAdapter.IListListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PokemonListViewModel by viewModels()
    private lateinit var adapter: PokemonListAdapter
    private var pokemonList: MutableList<PokemonListQuery.Result> = arrayListOf()
    private var loading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.queryPokemonList()
        observeData()
    }
    private fun observeData(){
        viewModel.pokemonList.observe(this){ response ->
            when(response) {
                is ViewState.Success ->{
                   val results = response.value?.data?.pokemons?.results
                   pokemonList.addAll(results as MutableList<PokemonListQuery.Result>)
                   initList()
                }
                is ViewState.Error -> {
                    pokemonList = mutableListOf()
                    initList()
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    pokemonList = mutableListOf()
                }
            }
        }

        viewModel.pokemonPaginationList.observe(this){ response ->
            when(response) {
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemons?.results
                    pokemonList.addAll(results as MutableList<PokemonListQuery.Result>)
                    loading =false
                }
                is ViewState.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                else -> {

                }
            }
        }

    }

    private fun initList() {
        adapter = PokemonListAdapter(pokemonList, this)
        setRecycler()
    }
    private fun setRecycler() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
         binding.rvPokemon.adapter = adapter
         binding.rvPokemon.layoutManager = linearLayoutManager
         binding.rvPokemon.addOnScrollListener(object : RecyclerView.OnScrollListener() {

             override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                 val layoutManager = LinearLayoutManager::class.java.cast(binding.rvPokemon.layoutManager)
                 val totalItemCount = layoutManager.itemCount;
                 val lastVisible = layoutManager.findLastVisibleItemPosition();
                 val endHasBeenReached = lastVisible + 10 >= totalItemCount
                 if(totalItemCount > 0 && endHasBeenReached && !loading){
                     loading = true
                     viewModel.queryMorePokemon()
                 }
             }
         })
    }

    override fun pokemonDetail(name: String, id: String ,image : String) {
        val intent = Intent(this, PokemonDetail::class.java)
        val bundle = Bundle()
        bundle.putString("pokemonName", name)
        bundle.putString("pokemonImage", image)
        bundle.putString("pokemonId", id )
        intent.putExtras(bundle);
        startActivity(intent)
    }
}
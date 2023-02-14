package com.example.pokedex.ui.pokemonList.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.ui.pokemonDetail.view.PokemonDetail
import com.example.pokedex.ui.pokemonList.adapter.PokemonListAdapter
import com.example.pokedex.ui.pokemonList.viewModel.PokemonListViewModel
import com.example.pokedex.utils.IListListener
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonListQuery
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class PokemonList : AppCompatActivity(), IListListener{
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PokemonListViewModel by viewModels()
    private lateinit var adapter: PokemonListAdapter
    private var pokemonList: ArrayList<PokemonListQuery.Result> = arrayListOf()
    private var loading = false
    private var searchedPokemon = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.queryPokemonList()
        observeData()
        initSearchView()
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
                    pokemonList = arrayListOf()
                    initList()
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    pokemonList = arrayListOf()
                }
            }
        }

        viewModel.pokemonPaginationList.observe(this){ response ->
            when(response) {
                is ViewState.Success ->{
                    val results = response.value?.data?.pokemons?.results
                    pokemonList.addAll(results as MutableList<PokemonListQuery.Result>)
                    loading = false
                }
                is ViewState.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
                is ViewState.Loading -> {
                    loading = true
                }
                else -> {
                    Toast.makeText(this, "unknown Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    private fun initSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(qString: String): Boolean {
                filter(qString)
                return true
            }
            override fun onQueryTextSubmit(qString: String): Boolean {
                return true
            }
        })
    }
    private fun filter(text : String){
        val filteredList = ArrayList<PokemonListQuery.Result>()
        for (item in pokemonList) {
            if (item.name!!.lowercase().contains(text.lowercase(Locale.getDefault()))){
                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No pokemon found", Toast.LENGTH_SHORT).show()
        } else {
            adapter.filterList(filteredList)
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
                 if(totalItemCount > 0 && endHasBeenReached && !loading && !searchedPokemon){
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
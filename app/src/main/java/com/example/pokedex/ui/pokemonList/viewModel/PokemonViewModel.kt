package com.example.pokedex.ui.pokemonList.viewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.api.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.exception.ApolloException
import com.example.pokedex.repository.interfaces.PokemonRepository
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonListQuery
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonViewModel
@Inject constructor(private val repository: PokemonRepository): ViewModel()  {
    private val _PokemonList by lazy { MutableLiveData<ViewState<Response<PokemonListQuery.Data>>>() }
    val pokemonList: LiveData<ViewState<Response<PokemonListQuery.Data>>>
        get() = _PokemonList

    fun queryPokemonList() = viewModelScope.launch {
        _PokemonList.postValue(ViewState.Loading())
        try {
            val response = repository.getPokemons()
            _PokemonList.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            Log.d("ApolloException", "Failure", e)
            _PokemonList.postValue(ViewState.Error("Error fetching characters"))
        }
    }
}





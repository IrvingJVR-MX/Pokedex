package com.example.pokedex.ui.pokemonList.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.api.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.exception.ApolloException
import com.example.pokedex.repository.manager.interfaces.PokemonSource
import com.example.pokedex.utils.PokemonHelper
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonListQuery
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonListViewModel
@Inject constructor(private val repository: PokemonSource): ViewModel()  {
    private val _PokemonList by lazy { MutableLiveData<ViewState<Response<PokemonListQuery.Data>>>() }
    private var offset = 0
    private val _PokemonPaginationList by lazy { MutableLiveData<ViewState<Response<PokemonListQuery.Data>>>() }
    val pokemonList: LiveData<ViewState<Response<PokemonListQuery.Data>>> get() = _PokemonList
    val pokemonPaginationList: LiveData<ViewState<Response<PokemonListQuery.Data>>> get() = _PokemonPaginationList

    fun queryPokemonList() = viewModelScope.launch {
        _PokemonList.postValue(ViewState.Loading())
        try {
            val response = repository.getPokemonList(PokemonHelper.Constants.pokemonListLimit,0)
            _PokemonList.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            _PokemonList.postValue(ViewState.Error("Error"))
        }
    }

    fun queryMorePokemon() = viewModelScope.launch{
        offset += PokemonHelper.Constants.pokemonListLimit
        _PokemonPaginationList.postValue(ViewState.Loading())
            try {
                val response = repository.getPokemonList(PokemonHelper.Constants.pokemonListLimit,offset)
                _PokemonPaginationList.postValue(ViewState.Success(response))
            } catch (e: ApolloException) {
                _PokemonPaginationList.postValue(ViewState.Error("Error"))
            }
    }
}





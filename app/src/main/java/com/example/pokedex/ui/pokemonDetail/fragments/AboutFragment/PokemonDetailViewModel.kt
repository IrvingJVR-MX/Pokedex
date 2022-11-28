package com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.pokedex.repository.interfaces.PokemonSource
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonDetailQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel
@Inject constructor(private val repository: PokemonSource): ViewModel()  {
    private  val _PokemonDetail by lazy { MutableLiveData <ViewState<Response<PokemonDetailQuery.Data>>>() }
    val pokemonDetail: LiveData<ViewState<Response<PokemonDetailQuery.Data>>> get() = _PokemonDetail

    fun queryPokemonDetail(name: String) = viewModelScope.launch{
        _PokemonDetail.postValue(ViewState.Loading())
        try {
            val response = repository.getPokemonDetail(name)
            _PokemonDetail.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            Log.d("ApolloException", "Failure", e)
            _PokemonDetail.postValue(ViewState.Error("Error fetching"))
        }
    }
}
package com.example.pokedex.ui.pokemonDetail.fragments.StatFragment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.pokedex.repository.remote.interfaces.PokemonRepository
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonStatsInfoQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatViewModel
@Inject constructor(private val repository: PokemonRepository): ViewModel()  {
    private  val _PokemonStats by lazy { MutableLiveData <ViewState<Response<PokemonStatsInfoQuery.Data>>>() }
    val pokemonStats: LiveData<ViewState<Response<PokemonStatsInfoQuery.Data>>> get() = _PokemonStats

    fun queryPokemonStats(name: String) = viewModelScope.launch{
        _PokemonStats.postValue(ViewState.Loading())
        try {
            val response = repository.getPokemonStatsInfo(name)
            _PokemonStats.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            Log.d("ApolloException", "Failure", e)
            _PokemonStats.postValue(ViewState.Error("Error fetching"))
        }
    }


}
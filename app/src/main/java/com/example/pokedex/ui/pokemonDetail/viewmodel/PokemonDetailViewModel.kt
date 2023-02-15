package com.example.pokedex.ui.pokemonDetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.pokedex.repository.remote.interfaces.PokemonRepository
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonTypeInfoQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel
@Inject constructor(private val repository: PokemonRepository): ViewModel() {
    private  val _PokemonTypeInfo by lazy { MutableLiveData <ViewState<Response<PokemonTypeInfoQuery.Data>>>() }
    val pokemonTypeInfo: LiveData<ViewState<Response<PokemonTypeInfoQuery.Data>>> get() = _PokemonTypeInfo

    fun queryPokemonType(name: String) = viewModelScope.launch{
        _PokemonTypeInfo.postValue(ViewState.Loading())
        try {
            val response = repository.getPokemonTypeInfo(name)
            _PokemonTypeInfo.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            _PokemonTypeInfo.postValue(ViewState.Error("Error"))
        }
    }
}



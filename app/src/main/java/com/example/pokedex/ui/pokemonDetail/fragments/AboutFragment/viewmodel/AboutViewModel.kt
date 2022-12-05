package com.example.pokedex.ui.pokemonDetail.fragments.AboutFragment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.pokedex.repository.manager.interfaces.PokemonSource
import com.example.pokedex.utils.ViewState
import com.graphqlapollo.PokemonAboutInfoQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutViewModel
@Inject constructor(private val repository: PokemonSource): ViewModel()  {

    private  val _PokemonAboutInfo by lazy { MutableLiveData <ViewState<Response<PokemonAboutInfoQuery.Data>>>() }
    val pokemonAboutInfo: LiveData<ViewState<Response<PokemonAboutInfoQuery.Data>>> get() = _PokemonAboutInfo

    fun queryPokemonDetail(name: String) = viewModelScope.launch{
        _PokemonAboutInfo.postValue(ViewState.Loading())
        try {
            val response = repository.getPokemonAboutInfo(name)
            _PokemonAboutInfo.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            _PokemonAboutInfo.postValue(ViewState.Error("Error"))
        }
    }
}
package com.example.pokedex

import android.app.Application
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokedexApp: Application() {
    override fun onCreate() {
        super.onCreate()
        resource = resources
    }
    companion object {
        var resource: Resources? = null
    }
}
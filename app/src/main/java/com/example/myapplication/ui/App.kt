package com.example.myapplication.ui

import android.app.Application
import com.example.myapplication.date.RickAndMortyApi
import com.example.myapplication.date.repository.MainEpisode
import com.example.myapplication.date.repository.MainLocation
import com.example.myapplication.date.repository.MainRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    companion object {
        lateinit var repo: MainRepository
        lateinit var location: MainLocation
        lateinit var episode: MainEpisode
    }

    override fun onCreate() {
        super.onCreate()
        //Character
        val api = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
        repo = MainRepository(api)
        location = MainLocation(api)
        episode = MainEpisode(api)
    }
}
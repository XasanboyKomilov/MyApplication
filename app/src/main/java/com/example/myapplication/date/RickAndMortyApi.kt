package com.example.myapplication.date

import com.example.myapplication.madel.CharacrterResult
import com.example.myapplication.madel.EpisodeResult
import com.example.myapplication.madel.LocationResult
import com.example.myapplication.madel.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    fun getCharacter(): Call<MainResponse<CharacrterResult>>

    @GET("location")
    fun getLocation(): Call<MainResponse<LocationResult>>

    @GET("episode")
    fun getEpisode(): Call<MainResponse<EpisodeResult>>
}
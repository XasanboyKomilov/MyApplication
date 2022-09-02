package com.example.myapplication.madel

import com.example.myapplication.date.RickAndMortyApi
import com.google.gson.annotations.SerializedName

data class EpisodeResult(
    val id: RickAndMortyApi? = null,
    val name:String? = null,
    @SerializedName("air_date")
    val airDate:String? = null,
    val episode:String? = null
)
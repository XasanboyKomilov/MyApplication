package com.example.myapplication.date.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.common.Resourse
import com.example.myapplication.date.RickAndMortyApi
import com.example.myapplication.madel.EpisodeResult
import com.example.myapplication.madel.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainEpisode(private val api: RickAndMortyApi) {
    fun getEpisode(): MutableLiveData<Resourse<MainResponse<EpisodeResult>?>> {
        var episode = MutableLiveData<Resourse<MainResponse<EpisodeResult>?>>()
        episode.value = Resourse.loading()
        api.getEpisode().enqueue(object : Callback<MainResponse<EpisodeResult>?> {
            override fun onResponse(
                call: Call<MainResponse<EpisodeResult>?>,
                response: Response<MainResponse<EpisodeResult>?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null){
                        episode.value = Resourse.success(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<MainResponse<EpisodeResult>?>, t: Throwable) {
                episode.value = t.message?.let { Resourse.error(it) }
            }
        })
        return episode
    }
}
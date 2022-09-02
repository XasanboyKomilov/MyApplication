package com.example.myapplication.date.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.common.Resourse
import com.example.myapplication.date.RickAndMortyApi
import com.example.myapplication.madel.LocationResult
import com.example.myapplication.madel.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainLocation(private val api: RickAndMortyApi) {
    fun getLocation(): MutableLiveData<Resourse<MainResponse<LocationResult>?>> {
        var location = MutableLiveData<Resourse<MainResponse<LocationResult>?>>()
        location.value = Resourse.loading()
        api.getLocation().enqueue(object : Callback<MainResponse<LocationResult>?> {
            override fun onResponse(
                call: Call<MainResponse<LocationResult>?>,
                response: Response<MainResponse<LocationResult>?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null){
                        location.value = Resourse.success(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<MainResponse<LocationResult>?>, t: Throwable) {
                location.value = t.message?.let { Resourse.error(it) }
            }
        })
        return location
    }
}
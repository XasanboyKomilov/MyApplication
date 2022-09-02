package com.example.myapplication.date.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.common.Resourse
import com.example.myapplication.date.RickAndMortyApi
import com.example.myapplication.madel.CharacrterResult
import com.example.myapplication.madel.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val api: RickAndMortyApi) {
    fun getCharacter(): MutableLiveData<Resourse<MainResponse<CharacrterResult>?>> {
        var character = MutableLiveData<Resourse<MainResponse<CharacrterResult>?>>()
        character.value = Resourse.loading()
        api.getCharacter().enqueue(object : Callback<MainResponse<CharacrterResult>?> {
            override fun onResponse(
                call: Call<MainResponse<CharacrterResult>?>,
                response: Response<MainResponse<CharacrterResult>?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        character.value = Resourse.success(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<MainResponse<CharacrterResult>?>, t: Throwable) {
                character.value = t.message?.let { Resourse.error(it) }
            }
        })
        return character
    }
}
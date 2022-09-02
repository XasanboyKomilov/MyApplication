package com.example.myapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.Resourse
import com.example.myapplication.madel.CharacrterResult
import com.example.myapplication.madel.MainResponse
import com.example.myapplication.ui.App

class HomeViewModel : ViewModel() {
    var liveDate = MutableLiveData<Resourse<MainResponse<CharacrterResult>?>>()
    fun getCharacter() {
        liveDate = App.repo.getCharacter()
    }
}
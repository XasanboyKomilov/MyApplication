package com.example.myapplication.ui.notifications

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.Resourse
import com.example.myapplication.madel.LocationResult
import com.example.myapplication.madel.MainResponse
import com.example.myapplication.ui.App

class NotificationViewMadel : ViewModel() {

    var liveDate = MutableLiveData<Resourse<MainResponse<LocationResult>?>>()
    fun getLocation() {
        liveDate = App.location.getLocation()
    }
}
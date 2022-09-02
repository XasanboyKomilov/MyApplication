package com.example.myapplication.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.Resourse
import com.example.myapplication.madel.EpisodeResult
import com.example.myapplication.madel.MainResponse
import com.example.myapplication.ui.App

class DashboardViewMadel : ViewModel() {
    var liveDate = MutableLiveData<Resourse<MainResponse<EpisodeResult>?>>()
    fun getEpisode() {
        liveDate = App.episode.getEpisode()
    }
}
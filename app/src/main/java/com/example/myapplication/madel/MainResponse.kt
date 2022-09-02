package com.example.myapplication.madel


data class MainResponse<T>(
    val results: List<T>,
)
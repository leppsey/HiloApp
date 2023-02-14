package com.example.hiloapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val liveDataCountOfPlayers=MutableLiveData<Int>()
    val liveDataList = MutableLiveData<List<String>>()

}
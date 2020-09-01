package com.example.rickyandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {

    // step 1: create instanc eof live data to hold the to hold certain type of data
    val textTest = MutableLiveData<String>()

    fun updateText() {
        textTest.value = "123456"
    }


}
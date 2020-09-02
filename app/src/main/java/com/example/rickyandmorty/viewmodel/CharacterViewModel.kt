package com.example.rickyandmorty.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {

    // step 1: create instanc eof live data to hold the to hold certain type of data
    val mutableLiveDataOne = MutableLiveData<String>()


    // create another Live Data with a string

    val mutableLiveDatatwo :MutableLiveData<String> by lazy {
      MutableLiveData<String>()
    }

    fun updateText() {
        mutableLiveDataOne.value = "123456"
    }


}
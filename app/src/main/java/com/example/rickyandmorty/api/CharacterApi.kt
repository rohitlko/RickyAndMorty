package com.example.rickyandmorty.api

import com.example.rickyandmorty.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApi {

    @GET("character/")
    fun getCharacters(): Call<Data>
}
package com.example.rickyandmorty

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.rickyandmorty.api.CharacterApi
import com.example.rickyandmorty.model.Data
import com.example.rickyandmorty.viewmodel.CharacterViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonOk = findViewById<Button>(R.id.btn_click)

        // create observer object to control live data change
        val nameObserver = Observer<String> { testName ->
            Log.d("Test", "$testName")
        }

        // characterViewModel.textTest.observe(this, nameObserver)

        buttonOk.setOnClickListener {
            Toast.makeText(this, "Button is clicked", Toast.LENGTH_LONG).show()
            characterViewModel.textTest.observe(this, nameObserver)
            characterViewModel.textTest.value = "rohit"
            characterViewModel.textTest.value = "Jonathan"
            characterViewModel.updateText()
        }
    }


    fun fetchCharacter() {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CharacterApi::class.java)
        service.getCharacters().enqueue(object : Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.e("Test", "Failed ${t.message}")
            }

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                Log.d("Test", response.body().toString())
            }
        })
    }
}
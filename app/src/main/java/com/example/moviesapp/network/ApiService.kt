package com.example.moviesapp.network

import com.example.moviesapp.model.Movies
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("movielist.json")
    suspend fun getMovie(): List<Movies>

    //Get Instance of api
    companion object{
        var apiService : ApiService? = null
        fun getInstance():ApiService{
            if(apiService == null){
               apiService = Retrofit.Builder()
                   .baseUrl("https://howtodoandroid.com/apis/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}
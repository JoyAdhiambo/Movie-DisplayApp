package com.example.moviesapp.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.Movies
import com.example.moviesapp.network.ApiService
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MovieViewModel :ViewModel() {
    var movieListResponse :List<Movies> by mutableStateOf(listOf())
   var errorMessage : String by mutableStateOf("")
    fun getMovieList(){
        viewModelScope.launch {
            val apiservice = ApiService.getInstance()
            try {
                val movielist = apiservice.getMovie()
                movieListResponse = movielist
            }
            catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}
package com.example.tractionassignment.Service

import com.example.tractionassignment.Domain.Models.Movielistbaseresponse
import retrofit2.Response
import retrofit2.http.GET

interface Movielistinterface {

    //@GET("popular?api_key=87a901020f496977f9d6d508c5d186ec")
    @GET("popular?api_key=d5d51f91a3eaeb3468756a9e2cf2495c")
    suspend fun fetchMovies():Response<Movielistbaseresponse>

}
package com.harsh.upcomingmovies.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieListService {

    @GET("movie/upcoming")
    fun movieList(@Query("api_key") api_key : String): Call<JsonObject>

}
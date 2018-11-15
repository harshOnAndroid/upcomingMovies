package com.harsh.upcomingmovies.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.harsh.upcomingmovies.bean.Movie
import com.harsh.upcomingmovies.network.MovieListService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesViewModel : ViewModel() {
val moviesLiveData = MutableLiveData<ArrayList<Movie>>()

    fun getMovies(): LiveData<ArrayList<Movie>> {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val moviesApi = retrofit.create(MovieListService::class.java)

        moviesApi.movieList("c6c686e6d92c48d7db6198c6667b6694").enqueue(object: Callback<JsonObject?> {
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                moviesLiveData.value = null
            }

            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.isSuccessful){

                    val responseObject = response.body()
                    val moviesArr = responseObject?.getAsJsonArray("results")
                    moviesLiveData.value = Gson().fromJson(
                        moviesArr.toString(),
                        object : TypeToken<ArrayList<Movie>>(){}.type
                    )
                }

            }
        })

        return moviesLiveData

    }
}
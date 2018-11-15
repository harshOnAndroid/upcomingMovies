package com.harsh.upcomingmovies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.harsh.upcomingmovies.R
import com.harsh.upcomingmovies.bean.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        val s = intent?.extras?.getString("movie")
        val movie =  Gson().fromJson(s, Movie::class.java)

        movieTitle.text = movie.title
        overview.text = movie.overview
        ratingBar.rating = movie.vote_average
        ratingBar.stepSize = 0.5f
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185_and_h278_bestv2${movie.poster_path}")
//            .load("https://image.tmdb.org/t/p/w1400_and_h450_face/${movie.poster_path}")
            .into(image)
    }
}
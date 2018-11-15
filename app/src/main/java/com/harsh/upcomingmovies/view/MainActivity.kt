package com.harsh.upcomingmovies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.google.gson.Gson
import com.harsh.upcomingmovies.R
import com.harsh.upcomingmovies.bean.Movie
import com.harsh.upcomingmovies.data.MoviesAdapter
import com.harsh.upcomingmovies.viewmodels.MoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MoviesAdapter.OnItemClickListener {
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Movies"


        adapter = MoviesAdapter(this, this)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            VERTICAL,
            false
        )
        recyclerView.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        viewModel.getMovies().observe(this, Observer { t -> updateList(t) })

    }

    fun updateList(list: ArrayList<Movie>) {
        adapter.updateList(list)
    }

    override fun onClick(movie: Movie) {
        val intent = Intent(
            this,
            DetailActivity::class.java
        )

        val b = Bundle()
        b.putString("movie", Gson().toJson(movie))
        intent.putExtras(b)
        startActivity(intent)
    }
}

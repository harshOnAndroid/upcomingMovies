package com.harsh.upcomingmovies.data

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.harsh.upcomingmovies.R
import com.harsh.upcomingmovies.bean.Movie

class MoviesAdapter(val context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<MoviesAdapter.MovieVH>() {
    val movies : ArrayList<Movie> = ArrayList(0)

    override fun getItemCount(): Int {

        return movies.size
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {

        val movie = movies.get(position)
        holder.name.setText(movie.title);
        holder.date.text = movie.releaseDate
        holder.certificate.text = if(movie.isAdult) "(U/A)" else "(U)"
        Glide.with(context)
//            .load("https://cdn.shopify.com/s/files/1/0151/0741/products/4e3e4dd6150b61ac341ab7ea95c7d570_480x480.jpeg?v=1457856710")
            .load("https://image.tmdb.org/t/p/w185_and_h278_bestv2${movie.poster_path}")
            .into(holder.image)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieVH {

        return MovieVH(View.inflate(context, R.layout.movie_item, null))
    }

    fun updateList(list : ArrayList<Movie>){
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    class MovieVH(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val name = itemView.findViewById<TextView>(R.id.name)
        val date = itemView.findViewById<TextView>(R.id.date)
        val certificate = itemView.findViewById<TextView>(R.id.certificate)

    }
}
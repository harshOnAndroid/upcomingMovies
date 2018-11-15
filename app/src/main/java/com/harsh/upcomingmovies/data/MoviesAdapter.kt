package com.harsh.upcomingmovies.data

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.harsh.upcomingmovies.R
import com.harsh.upcomingmovies.bean.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesAdapter(val context: Context, onItemClickListener: OnItemClickListener) : androidx.recyclerview.widget.RecyclerView.Adapter<MoviesAdapter.MovieVH>() {
    val movies : ArrayList<Movie> = ArrayList(0)
    private val onItemClickListener = onItemClickListener

    override fun getItemCount(): Int {

        return movies.size
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {

        val movie = movies.get(position)
        holder.name.setText(movie.title);
        holder.date.text = movie.releaseDate
        holder.certificate.text = if(movie.isAdult) "(A)" else "(U/A)"
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w185_and_h278_bestv2${movie.poster_path}")
            .into(holder.image)
        holder.movieItem.setOnClickListener { onItemClickListener.onClick(movie) }
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
        val image = itemView.image
        val name = itemView.name
        val date = itemView.date
        val certificate = itemView.certificate
        val movieItem = itemView.movieItem
    }

    interface OnItemClickListener{
        fun onClick(movie:Movie)
    }
}
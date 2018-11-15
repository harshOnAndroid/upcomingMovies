package com.harsh.upcomingmovies.bean

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("release_date")
    var releaseDate: String? = null

    var id: Int = 0

    var title: String? = null

    @SerializedName("adult")
    var isAdult: Boolean = false

    var poster_path: String? = null

    var overview: String? = null
    var vote_average: Float = 0.0f

    override fun toString(): String {
        return """"{release_date = ${releaseDate.toString()},
            id = ${id},
            title = $title,
            adult = $isAdult,
            poster_path = $poster_path,
            overview = $overview,
            vote_average = $vote_average
                }"""
    }
}
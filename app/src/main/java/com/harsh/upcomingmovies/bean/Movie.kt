package com.harsh.upcomingmovies.bean

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String? = null

    @SerializedName("adult")
    var isAdult: Boolean = false

    var poster_path : String ? = null

    override fun toString(): String {
        return """"Movie{ +
                release_date = ${releaseDate.toString()}
                ,id = ${id}
                ,title = $title
                ,adult = $isAdult
                ,poster_path = $poster_path
                }"""
    }
}
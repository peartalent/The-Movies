package com.vietis.themovies.data.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("results")
    var movies: List<MovieResponse>
)

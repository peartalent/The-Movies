package com.vietis.themovies.util.api

object ApiEndPoint {
    const val GET_POPULAR_MOVIE = "movie/popular"
    const val GET_TOP_RATE_MOVIE = "movie/top_rated"
    const val GET_UPCOMING_MOVIE = "movie/upcoming"
    const val GET_DETAIL_MOVIE = "movie/{id}"
    const val GET_MOVIE_BY_GENRE =
        "discover/movie?sort_by=popularity.desc&with_genres={id}"
    const val GET_VIDEO = "movie/{id}/videos"
    const val GET_RECOMMEND_MOVIE = "movie/{id}/recommendations"
    const val GET_ACTOR_OF_MOVIE = "movie/{id}/credits"

    const val GET_DETAIL_ACTOR = "person/{id}"
    const val GET_MOVIE_OF_ACTOR = "person/{id}/movie_credits"

    const val PARAMS_ID = "id"
}

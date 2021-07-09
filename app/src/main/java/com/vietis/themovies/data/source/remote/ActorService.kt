package com.vietis.themovies.data.source.remote

import com.vietis.themovies.data.model.Actor
import com.vietis.themovies.data.model.MovieListResponse
import com.vietis.themovies.util.api.ApiEndPoint
import com.vietis.themovies.util.api.ApiEndPoint.PARAMS_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ActorService {
    @GET(ApiEndPoint.GET_MOVIE_OF_ACTOR)
    fun getMovieOfActor(@Path(PARAMS_ID) actorId: Int): Response<MovieListResponse>

    @GET(ApiEndPoint.GET_DETAIL_ACTOR)
    fun getDetailActor(@Path(PARAMS_ID) actorId: Int): Response<Actor>
}
